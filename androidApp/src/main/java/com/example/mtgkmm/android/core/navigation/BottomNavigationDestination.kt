package com.example.mtgkmm.android.core.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mtgkmm.android.feature.card.navigation.SearchDestination
import com.example.mtgkmm.android.feature.settings.navigation.SettingsDestination

abstract class BottomNavigationDestination<T>(
    @StringRes val resourceId: Int,
    @DrawableRes val iconId: Int,
) : NavigationDestination<T> {

    companion object {
        val bottomNavigationItems = listOf(
            SearchDestination,
            SettingsDestination,
        )
    }
}

