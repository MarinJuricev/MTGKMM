package com.example.mtgkmm.android.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mtgkmm.android.search.components.MtgCardGrid
import com.example.mtgkmm.android.search.model.SearchEvent
import com.example.mtgkmm.android.search.model.SearchState

@Composable
fun SearchScreen(
    state: SearchState,
    onEvent: (SearchEvent) -> Unit,
) {
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
                onEvent = onEvent,
            )
        }
    }
}
