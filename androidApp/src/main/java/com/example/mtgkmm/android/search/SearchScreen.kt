package com.example.mtgkmm.android.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mtgkmm.android.search.components.MtgCardGrid
import com.example.mtgkmm.android.search.model.SearchEvent
import com.example.mtgkmm.android.search.model.SearchEvent.OnSearchUpdate
import com.example.mtgkmm.android.search.model.SearchState

@Composable
fun SearchScreen(
    state: SearchState,
    onEvent: (SearchEvent) -> Unit,
) {

    Scaffold(
        topBar = {
            TopAppBar {
                OutlinedTextField(
                    value = state.currentSearch,
                    onValueChange = { updatedSearch ->
                        onEvent(OnSearchUpdate(updatedSearch))
                    }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            AnimatedVisibility(
                visible = state.isLoading,
            ) {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            state.data?.let { data ->
                MtgCardGrid(data.cards)
            }
        }
    }
}
