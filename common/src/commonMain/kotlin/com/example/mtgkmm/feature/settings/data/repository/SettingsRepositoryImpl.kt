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
        keyValueStorage.observeItem(SORT_KEY).map {
            listOf(generateSortSettingsItem(it))
        }

    override suspend fun updateSort(
        updatedSort: String,
    ): Either<Failure, Unit> = keyValueStorage.updateItem(SORT_KEY, updatedSort)

    private fun generateSortSettingsItem(
        value: String
    ) = SettingsItem(
        id = SORT_KEY,
        name = "Sort Order",
        value = value,
    )
}

private const val SORT_KEY = "sort"