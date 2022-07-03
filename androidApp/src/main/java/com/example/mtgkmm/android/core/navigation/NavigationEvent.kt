package com.example.mtgkmm.android.core.navigation

sealed interface NavigationEvent {
    object NavigateUp : NavigationEvent
    object NavigateBack : NavigationEvent
    data class Destination(val destination: String) : NavigationEvent
}
