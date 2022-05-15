package com.example.mtgkmm.android.search.model

sealed interface SearchEvent {
    data class OnGetCards(val cardName: String): SearchEvent

}