package com.example.mtgkmm.android.core.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink

fun interface NavigationDestination<T> {

    fun route(): String
    fun buildRoute(data: T): String = route()
    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()
}