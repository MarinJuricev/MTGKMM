package com.example.mtgkmm.android.core.di

import com.example.mtgkmm.android.core.navigation.Navigator
import org.koin.dsl.module

val coreModule = module {
    single { Navigator() }
}