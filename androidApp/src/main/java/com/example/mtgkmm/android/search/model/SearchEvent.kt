package com.example.mtgkmm.android.search.model

sealed interface SearchEvent {
    object OnGetCards: SearchEvent
    data class OnSearchUpdate(val cardName: String): SearchEvent
}