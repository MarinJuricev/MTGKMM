package com.example.mtgkmm.android.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mtgkmm.android.core.components.topbar.MtgTopBar
import com.example.mtgkmm.android.core.components.topbar.TopBarViewModel
import com.example.mtgkmm.android.core.components.topbar.model.TopBarEvent
import com.example.mtgkmm.android.core.navigation.BottomNavigationDestination.Companion.bottomNavigationItems
import com.example.mtgkmm.android.core.navigation.NavigationEvent.Destination
import com.example.mtgkmm.android.core.navigation.NavigationEvent.NavigateBack
import com.example.mtgkmm.android.core.navigation.NavigationEvent.NavigateUp
import com.example.mtgkmm.android.feature.card.navigation.CardRootDestination
import com.example.mtgkmm.android.feature.card.navigation.buildCardGraph
import com.example.mtgkmm.android.feature.settings.navigation.buildSettingsGraph
import org.koin.androidx.compose.getViewModel

val LocalTopBarEvents: ProvidableCompositionLocal<((TopBarEvent) -> Unit)?> = compositionLocalOf {
    null
}

@Composable
fun MtgNavigation(
    navigator: Navigator,
    navController: NavHostController = rememberNavController(),
    topBarViewModel: TopBarViewModel = getViewModel()
) {
    LaunchedEffect(key1 = navigator) {
        navigator.navigationEvent.collect { navigationEvent ->
            when (navigationEvent) {
                NavigateUp -> navController.navigateUp()
                NavigateBack -> navController.popBackStack()
                is Destination -> navController.navigate(route = navigationEvent.destination)
            }
        }
    }

    CompositionLocalProvider(LocalTopBarEvents provides topBarViewModel::onEvent) {
        Scaffold(
            topBar = { MtgTopBar(topBarViewModel.state.collectAsState().value) },
            bottomBar = {
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    bottomNavigationItems.forEach { screen ->
                        MtgBottomNavigationItem(screen, currentDestination, navController)
                    }
                }
            }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = CardRootDestination.route(),
                modifier = Modifier.padding(paddingValues)
            ) {
                buildCardGraph()
                buildSettingsGraph()
            }
        }
    }
}
