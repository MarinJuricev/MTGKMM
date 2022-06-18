package com.example.mtgkmm.android.feature.settings.navigation

import com.example.mtgkmm.android.R
import com.example.mtgkmm.android.core.navigation.BottomNavigationDestination

object SettingsDestination : BottomNavigationDestination<Nothing>(
    resourceId = R.string.settings,
    iconId = R.drawable.settings,
) {

    override fun route(): String = "settings"

}