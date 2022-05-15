package com.example.mtgkmm.android.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.mtgkmm.android.search.viewmodel.SearchViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = getViewModel(),
) {
    val state by viewModel.state.collectAsState()
}