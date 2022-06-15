package com.example.mtgkmm.android.feature.settings.navigation

import androidx.compose.material.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.buildSettingsGraph() {
    navigation(
        startDestination = SettingsDestination.route(),
        route = SettingsRootDestination.route()
    ) {
        composable(SettingsDestination.route()) { navBackStackEntry ->
            Text("Settings")
        }
    }
}