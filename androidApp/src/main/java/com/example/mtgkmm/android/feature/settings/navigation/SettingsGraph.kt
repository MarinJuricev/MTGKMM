package com.example.mtgkmm.android.feature.settings.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mtgkmm.android.feature.settings.SettingsScreen
import org.koin.androidx.compose.getViewModel

fun NavGraphBuilder.buildSettingsGraph() {
    navigation(
        startDestination = SettingsDestination.route(),
        route = SettingsRootDestination.route()
    ) {
        composable(SettingsDestination.route()) { navBackStackEntry ->
            SettingsScreen(viewModel = getViewModel(owner = navBackStackEntry))
        }
    }
}
