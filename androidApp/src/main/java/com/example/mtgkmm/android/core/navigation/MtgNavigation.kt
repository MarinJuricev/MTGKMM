package com.example.mtgkmm.android.core.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.mtgkmm.android.core.topbar.MtgTopBar
import com.example.mtgkmm.android.core.topbar.TopBarViewModel
import com.example.mtgkmm.android.core.topbar.model.TopBarEvent
import com.example.mtgkmm.android.search.navigation.SearchDestination
import com.example.mtgkmm.android.search.navigation.SearchRootDestination
import com.example.mtgkmm.android.search.navigation.buildSearchGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.koin.androidx.compose.getViewModel

val LocalTopBarEvents: ProvidableCompositionLocal<((TopBarEvent) -> Unit)?> =
    compositionLocalOf { null }

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MtgNavigation(
    navigator: Navigator,
    navController: NavHostController = rememberNavController(),
    topBarViewModel: TopBarViewModel = getViewModel()
) {
    LaunchedEffect(key1 = navigator) {
        navigator.navigationEvent.collect { navigationEvent ->
            when (navigationEvent) {
                NavigationEvent.NavigateUp -> navController.navigateUp()
                NavigationEvent.NavigateBack -> navController.popBackStack()
                is NavigationEvent.Destination -> navController.navigate(
                    route = navigationEvent.destination
                )
            }
        }
    }

    CompositionLocalProvider(LocalTopBarEvents provides topBarViewModel::onEvent) {
        Scaffold(
            topBar = {
                MtgTopBar(topBarViewModel.state.collectAsState().value)
            }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = SearchRootDestination.route(),
                modifier = Modifier.padding(paddingValues)
            ) {
                buildSearchGraph()
            }
        }
    }
}