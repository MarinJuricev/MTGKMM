package com.example.mtgkmm.android.feature.card.search.model

import com.example.mtgkmm.android.feature.card.model.UiMtgCard

sealed interface SearchEvent {
    object OnGetCards : SearchEvent
    data class OnSearchUpdate(val cardName: String) : SearchEvent
    data class OnCardClick(val mtgCard: UiMtgCard) : SearchEvent
}
