package com.example.mtgkmm.android.search.navigation

import com.example.mtgkmm.android.core.navigation.NavigationDestination

object SearchDestination : NavigationDestination {

    override fun route(): String = SEARCH_ROUTE

}

private const val SEARCH_ROUTE = "search"
