package com.example.mtgkmm.android.core.topbar.model

import com.example.mtgkmm.android.core.topbar.TopBarViewState

sealed interface TopBarEvent {
    data class OnTopBarChange(val state: TopBarViewState) : TopBarEvent
}