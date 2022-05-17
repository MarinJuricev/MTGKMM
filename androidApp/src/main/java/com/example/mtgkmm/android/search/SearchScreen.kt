package com.example.mtgkmm.android.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.mtgkmm.android.search.model.SearchEvent.OnSearchUpdate
import com.example.mtgkmm.android.search.viewmodel.SearchViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = getViewModel(),
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar {
                OutlinedTextField(
                    value = state.currentSearch,
                    onValueChange = { updatedSearch ->
                        viewModel.onEvent(OnSearchUpdate(updatedSearch))
                    }
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {

        }
    }
}