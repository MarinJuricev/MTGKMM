package com.example.mtgkmm.android.feature.card.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.mtgkmm.android.R
import com.example.mtgkmm.android.core.components.MtgErrorScreen
import com.example.mtgkmm.android.core.components.topbar.TopBarViewState
import com.example.mtgkmm.android.core.components.topbar.model.TopBarEvent.OnTopBarChange
import com.example.mtgkmm.android.core.navigation.LocalTopBarEvents
import com.example.mtgkmm.android.feature.card.search.components.MtgCardGrid
import com.example.mtgkmm.android.feature.card.search.components.MtgRecentlyViewedCards
import com.example.mtgkmm.android.feature.card.search.components.MtgSearchTopBar
import com.example.mtgkmm.android.feature.card.search.viewmodel.SearchViewModel

@Composable
fun SearchScreen(viewModel: SearchViewModel) {
    val topBarEvent = LocalTopBarEvents.current
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = topBarEvent) {
        topBarEvent?.invoke(
            OnTopBarChange(
                TopBarViewState(isVisible = true) { MtgSearchTopBar(state, viewModel::onEvent) }
            )
        )
    }
    Column {
        AnimatedVisibility(visible = state.isLoading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }
        state.data?.let { data -> MtgCardGrid(cards = data.cards, onEvent = viewModel::onEvent) }

        if (state.data?.cards.isNullOrEmpty()) {
            MtgErrorScreen(
                modifier = Modifier.weight(0.8f),
                errorMessage = stringResource(id = R.string.empty_search)
            )
            AnimatedVisibility(visible = state.recentlyViewedCards.isNotEmpty()) {
                MtgRecentlyViewedCards(
                    modifier = Modifier.align(Alignment.End),
                    recentlyViewedCards = state.recentlyViewedCards,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}
