package com.example.mtgkmm.android.search.model

import com.example.mtgkmm.feature.search.domain.model.MtgCard

sealed interface SearchEvent {
    object OnGetCards: SearchEvent
    data class OnSearchUpdate(val cardName: String): SearchEvent
    data class OnCardClick(val mtgCard: MtgCard): SearchEvent
}