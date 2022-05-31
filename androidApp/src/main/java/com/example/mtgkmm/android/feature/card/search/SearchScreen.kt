package com.example.mtgkmm.android.feature.card.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mtgkmm.android.core.MtgAsyncImage
import com.example.mtgkmm.android.core.navigation.LocalTopBarEvents
import com.example.mtgkmm.android.core.topbar.TopBarViewState
import com.example.mtgkmm.android.core.topbar.model.TopBarEvent.OnTopBarChange
import com.example.mtgkmm.android.feature.card.search.components.MtgCardGrid
import com.example.mtgkmm.android.feature.card.search.components.MtgSearchTopBar
import com.example.mtgkmm.android.feature.card.search.model.SearchEvent.OnCardClick
import com.example.mtgkmm.android.feature.card.search.viewmodel.SearchViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
) {
    val topBarEvent = LocalTopBarEvents.current
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = topBarEvent) {
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

        if (state.data?.cards.isNullOrEmpty()) {
            Text("Empty")
            LazyRow {
                items(state.recentlyViewedCards, key = { mtgCard -> mtgCard.name }) { mtgCard ->
                    MtgAsyncImage(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(8.dp)
                            .clickable { viewModel.onEvent(OnCardClick(mtgCard)) },
                        url = mtgCard.url,
                        contentDescription = mtgCard.name,
                    )
                }
            }
        }
    }
}