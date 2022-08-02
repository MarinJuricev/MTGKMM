package com.example.mtgkmm.feature.settings.di

import SettingsRepository
import com.example.mtgkmm.feature.settings.data.repository.SettingsRepositoryImpl
import com.example.mtgkmm.feature.settings.domain.usecase.ObserveSettingsData
import com.example.mtgkmm.feature.settings.domain.usecase.UpdateSortType
import org.koin.dsl.module

val settingsModule = module {
    factory<SettingsRepository> { SettingsRepositoryImpl(keyValueStorage = get()) }
    factory { ObserveSettingsData(settingsRepository = get()) }
    factory { UpdateSortType() }
}