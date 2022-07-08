package com.example.mtgkmm.android.core.components.topbar

import androidx.lifecycle.viewModelScope
import com.example.mtgkmm.android.core.BaseViewModel
import com.example.mtgkmm.android.core.components.topbar.model.TopBarEvent
import com.example.mtgkmm.android.core.components.topbar.model.TopBarEvent.OnTopBarChange
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class TopBarViewModel : BaseViewModel<TopBarEvent>() {

    private val _state = MutableStateFlow(TopBarViewState())
    val state =
        _state.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            initialValue = TopBarViewState(),
        )

    override fun onEvent(event: TopBarEvent) {
        when (event) {
            is OnTopBarChange -> handleTopBarChange(event.state)
        }
    }

    private fun handleTopBarChange(state: TopBarViewState) {
        _state.update { state }
    }
}
