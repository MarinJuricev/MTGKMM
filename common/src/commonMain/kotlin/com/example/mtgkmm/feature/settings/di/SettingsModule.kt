package com.example.mtgkmm.feature.settings.di

import com.example.mtgkmm.feature.settings.domain.usecase.ObserveSettingsData
import com.example.mtgkmm.feature.settings.domain.usecase.SetSortType
import org.koin.dsl.module

val settingsModule = module {
    factory { ObserveSettingsData() }
    factory { SetSortType() }
}