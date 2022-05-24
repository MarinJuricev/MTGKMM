package com.example.mtgkmm.android.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.mtgkmm.android.core.navigation.LocalTopBarEvents
import com.example.mtgkmm.android.core.topbar.TopBarViewState
import com.example.mtgkmm.android.core.topbar.model.TopBarEvent.OnTopBarChange
import com.example.mtgkmm.android.search.components.MtgCardGrid
import com.example.mtgkmm.android.search.components.MtgSearchTopBar
import com.example.mtgkmm.android.search.viewmodel.SearchViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
) {
    val topBarEvent = LocalTopBarEvents.current
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit) {
        topBarEvent?.invoke(OnTopBarChange(TopBarViewState(isVisible = true) {
            MtgSearchTopBar(state, viewModel::onEvent)
        }))
    }
    Column {
        AnimatedVisibility(
            visible = state.isLoading,
        ) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
            )
        }
        state.data?.let { data ->
            MtgCardGrid(
                cards = data.cards,
                onEvent = viewModel::onEvent,
            )
        }
    }
}