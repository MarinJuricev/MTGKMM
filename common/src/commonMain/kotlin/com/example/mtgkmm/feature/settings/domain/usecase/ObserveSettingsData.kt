package com.example.mtgkmm.feature.settings.domain.usecase

import SettingsRepository
import com.example.mtgkmm.feature.settings.domain.model.SettingsItem
import kotlinx.coroutines.flow.Flow

class ObserveSettingsData(
    private val settingsRepository: SettingsRepository,
) {
    operator fun invoke(): Flow<List<SettingsItem>> =
        settingsRepository.observeSettingsData()
}

