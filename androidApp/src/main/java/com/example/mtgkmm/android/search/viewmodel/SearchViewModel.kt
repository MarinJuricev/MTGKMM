package com.example.mtgkmm.android.search.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.mtgkmm.android.core.BaseViewModel
import com.example.mtgkmm.android.search.model.SearchEvent
import com.example.mtgkmm.android.search.model.SearchEvent.OnGetCards
import com.example.mtgkmm.android.search.model.SearchState
import com.example.mtgkmm.core.Either.Left
import com.example.mtgkmm.core.Either.Right
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData
import com.example.mtgkmm.feature.search.domain.usecase.GetCards
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
    private val data = MutableStateFlow<MtgCardsData?>(null)
    private val isLoading = MutableStateFlow(false)

    val state = combine(data, error, isLoading) { data, error, isLoading ->
        SearchState(
            isLoading = isLoading,
            error = error,
            data = data,
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        initialValue = SearchState(),
    )

    override fun onEvent(event: SearchEvent) {
        when (event) {
            is OnGetCards -> handleOnGetCards(event.cardName)
        }
    }

    private fun handleOnGetCards(cardName: String) = viewModelScope.launch {
        when (val result = getCards(cardName)) {
            is Right -> data.update { result.value }
            is Left -> error.update { result.error.toString() }
        }
    }
}