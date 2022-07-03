package com.example.mtgkmm.android.feature.card.search.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.mtgkmm.android.core.BaseViewModel
import com.example.mtgkmm.android.core.TIMEOUT_DELAY
import com.example.mtgkmm.android.core.navigation.NavigationEvent.Destination
import com.example.mtgkmm.android.core.navigation.Navigator
import com.example.mtgkmm.android.feature.card.model.UiMtgCard
import com.example.mtgkmm.android.feature.card.model.UiMtgCardsData
import com.example.mtgkmm.android.feature.card.model.toUi
import com.example.mtgkmm.android.feature.card.navigation.CardDetailDestination
import com.example.mtgkmm.android.feature.card.search.model.SearchEvent
import com.example.mtgkmm.android.feature.card.search.model.SearchEvent.OnCardClick
import com.example.mtgkmm.android.feature.card.search.model.SearchEvent.OnGetCards
import com.example.mtgkmm.android.feature.card.search.model.SearchEvent.OnSearchUpdate
import com.example.mtgkmm.android.feature.card.search.model.SearchState
import com.example.mtgkmm.core.Either.Left
import com.example.mtgkmm.core.Either.Right
import com.example.mtgkmm.feature.search.domain.usecase.GetCards
import com.example.mtgkmm.feature.search.domain.usecase.ObserveRecentlyViewedCards
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getCards: GetCards,
    private val observeRecentlyViewedCards: ObserveRecentlyViewedCards,
    private val navigator: Navigator
) : BaseViewModel<SearchEvent>() {

    private val error = MutableStateFlow<String?>(null)
    private val cardData = MutableStateFlow<UiMtgCardsData?>(null)
    private val searchText = MutableStateFlow("")
    private val recentlyViewedCards = MutableStateFlow<List<UiMtgCard>>(emptyList())
    private val isLoading = MutableStateFlow(false)

    private var searchJob: Job? = null

    init {
        viewModelScope.launch {
            observeRecentlyViewedCards()
                .onEach { mtgCards -> recentlyViewedCards.update { mtgCards.map { it.toUi() } } }
                .stateIn(this)
        }
    }

    val state =
        combine(cardData, error, searchText, isLoading, recentlyViewedCards) {
                data,
                error,
                searchText,
                isLoading,
                recentlyViewedCards ->
            SearchState(
                isLoading = isLoading,
                error = error,
                currentSearch = searchText,
                data = data,
                recentlyViewedCards = recentlyViewedCards
            )
        }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(TIMEOUT_DELAY),
                initialValue = SearchState()
            )

    override fun onEvent(event: SearchEvent) {
        when (event) {
            is OnGetCards -> handleOnGetCards()
            is OnSearchUpdate -> handleSearchUpdate(event.cardName)
            is OnCardClick -> handleCardClick(event.mtgCard)
        }
    }

    private fun handleOnGetCards() =
        viewModelScope.launch {
            isLoading.update { true }
            when (val result = getCards(searchText.value)) {
                is Right -> cardData.update { result.value.toUi() }
                is Left -> error.update { result.error.toString() }
            }
            isLoading.update { false }
        }

    private fun handleSearchUpdate(cardName: String) {
        if (searchJob?.isActive == true) searchJob?.cancel()
        searchJob =
            viewModelScope.launch {
                isLoading.update { true }
                searchText.update { cardName }
                delay(SEARCH_DEBOUNCE)
                handleOnGetCards()
            }
    }

    private fun handleCardClick(mtgCard: UiMtgCard) =
        viewModelScope.launch {
            navigator.emitDestination(Destination(CardDetailDestination.buildRoute(mtgCard)))
        }
}

private const val SEARCH_DEBOUNCE = 500L
