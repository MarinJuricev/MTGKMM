package com.example.mtgkmm.feature.settings.data.repository

import SettingsRepository
import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.data.storage.KeyValueStorage
import com.example.mtgkmm.feature.settings.domain.model.SettingsItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsRepositoryImpl(
    private val keyValueStorage: KeyValueStorage,
) : SettingsRepository {
    override fun observeSettingsData(): Flow<List<SettingsItem>> =
        //TODO if more values come just combine the multiple emissions into the list
        keyValueStorage.observeItem(SORT_KEY).map {
            listOf(
                SettingsItem(
                    id = SORT_KEY,
                    name = "Sort Order",
                    value = it,
                )
            )
        }

    override suspend fun updateSettingsItem(
        settingsItem: SettingsItem
    ): Either<Failure, Unit> = keyValueStorage.updateItem(settingsItem.id, settingsItem.value)
}

private const val SORT_KEY = "sort"