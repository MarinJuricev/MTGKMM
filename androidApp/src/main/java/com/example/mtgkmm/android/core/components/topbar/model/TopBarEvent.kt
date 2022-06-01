package com.example.mtgkmm.android.core.components.topbar.model

import com.example.mtgkmm.android.core.components.topbar.TopBarViewState

sealed interface TopBarEvent {
    data class OnTopBarChange(val state: TopBarViewState) : TopBarEvent
}