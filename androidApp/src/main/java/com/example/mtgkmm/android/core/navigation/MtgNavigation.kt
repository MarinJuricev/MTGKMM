package com.example.mtgkmm.android.core.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mtgkmm.android.search.navigation.SearchRootDestination
import com.example.mtgkmm.android.search.navigation.buildSearchGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MtgNavigation(
    navigator: Navigator,
    navController: NavHostController = rememberAnimatedNavController(),
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

    Scaffold { paddingValues ->
        AnimatedNavHost(
            navController = navController,
            startDestination = SearchRootDestination.route(),
            modifier = Modifier.padding(paddingValues)
        ) {
            buildSearchGraph()
        }
    }

}