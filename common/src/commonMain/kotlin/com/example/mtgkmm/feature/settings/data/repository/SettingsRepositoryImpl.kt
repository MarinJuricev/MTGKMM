package com.example.mtgkmm.feature.settings.data.repository

import SettingRepository
import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.feature.settings.domain.model.SettingsItem
import com.russhwolf.settings.Settings
import kotlinx.coroutines.flow.Flow

class SettingsRepositoryImpl(
    private val keyValueStorage: KeyValueStorage,
): SettingRepository {
    override fun observeSettingsData(): Flow<List<SettingsItem>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateSettingsItem(settingsItem: SettingsItem): Either<Failure, Unit> {
        TODO("Not yet implemented")
    }
}