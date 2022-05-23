package com.example.mtgkmm.android.core.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class Navigator {

    private val _navigationEvent = Channel<NavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    suspend fun emitDestination(event: NavigationEvent) {
        _navigationEvent.send(event)
    }
}