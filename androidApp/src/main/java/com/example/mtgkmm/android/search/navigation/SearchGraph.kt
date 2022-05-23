package com.example.mtgkmm.android.search.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mtgkmm.android.search.SearchScreen
import com.example.mtgkmm.android.search.viewmodel.SearchViewModel
import org.koin.androidx.compose.getViewModel

fun NavGraphBuilder.buildSearchGraph() {
    navigation(
        startDestination = SearchDestination.route(),
        route = SearchRootDestination.route()
    ) {
        composable(SearchDestination.route()) {
            val viewModel: SearchViewModel = getViewModel()
            val state by viewModel.state.collectAsState()

            SearchScreen(
                state,
                viewModel::onEvent
            )
        }
    }
}

