package com.example.mtgkmm.android.search.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.mtgkmm.android.core.BaseViewModel
import com.example.mtgkmm.android.search.model.SearchEvent
import com.example.mtgkmm.android.search.model.SearchEvent.OnGetCards
import com.example.mtgkmm.android.search.model.SearchEvent.OnSearchUpdate
import com.example.mtgkmm.android.search.model.SearchState
import com.example.mtgkmm.core.Either.Left
import com.example.mtgkmm.core.Either.Right
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData
import com.example.mtgkmm.feature.search.domain.usecase.GetCards
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getCards: GetCards,
) : BaseViewModel<SearchEvent>() {

    private val error = MutableStateFlow<String?>(null)
    private val cardData = MutableStateFlow<MtgCardsData?>(null)
    private val searchText = MutableStateFlow("")
    private val isLoading = MutableStateFlow(false)

    val state = combine(
        cardData,
        error,
        searchText,
        isLoading,
    ) { data, error, searchText, isLoading ->
        SearchState(
            isLoading = isLoading,
            error = error,
            currentSearch = searchText,
            data = data,
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        initialValue = SearchState(),
    )

    override fun onEvent(event: SearchEvent) {
        when (event) {
            is OnGetCards -> handleOnGetCards()
            is OnSearchUpdate -> handleSearchUpdate(event.cardName)
        }
    }

    private fun handleOnGetCards() = viewModelScope.launch {
        when (val result = getCards(searchText.value)) {
            is Right -> cardData.update { result.value }
            is Left -> error.update { result.error.toString() }
        }
    }

    private fun handleSearchUpdate(cardName: String) = viewModelScope.launch {
        searchText.update { cardName }
        handleOnGetCards()
    }
}