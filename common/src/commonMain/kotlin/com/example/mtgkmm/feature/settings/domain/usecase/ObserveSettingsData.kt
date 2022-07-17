package com.example.mtgkmm.feature.settings.domain.usecase

import SettingRepository
import com.example.mtgkmm.feature.settings.domain.model.SettingsItem
import kotlinx.coroutines.flow.Flow

class ObserveSettingsData(
    private val settingsRepository: SettingRepository,
) {
    operator fun invoke(): Flow<List<SettingsItem>> {

    }
}

