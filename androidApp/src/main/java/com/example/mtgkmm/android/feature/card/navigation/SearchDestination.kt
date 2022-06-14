package com.example.mtgkmm.android.feature.card.navigation

import com.example.mtgkmm.android.R
import com.example.mtgkmm.android.core.navigation.BottomNavigationDestination

object SearchDestination : BottomNavigationDestination<Nothing>(
    resourceId = R.string.search,
    iconId = R.drawable.ic_100tb,
) {

    override fun route(): String = "search"

}