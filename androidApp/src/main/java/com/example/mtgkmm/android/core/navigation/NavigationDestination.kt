package com.example.mtgkmm.android.core.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.NavType

fun interface NavigationDestination<T> {

    fun route(): String
    fun buildRoute(data: T): String = route()
    fun retrieveRouteData(): T? = null
    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()

    abstract class ParamType<T> : NavType<T>(isNullableAllowed = false)
}
