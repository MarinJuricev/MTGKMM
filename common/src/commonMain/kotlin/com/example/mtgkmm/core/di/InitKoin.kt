package com.example.mtgkmm.core.di

import com.example.mtgkmm.feature.search.di.searchModule
import com.example.mtgkmm.feature.settings.di.settingsModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            platformModule(),
            commonModule(enableNetworkLogs),
            searchModule,
            settingsModule,
        )
    }

// Called by non Android consumers
fun initKoin() = initKoin(enableNetworkLogs = false) {}
