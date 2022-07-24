package com.example.mtgkmm.feature.settings.data.storage

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.buildRight
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.coroutines.FlowSettings
import com.russhwolf.settings.get
import com.russhwolf.settings.set
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalSettingsApi::class)
class KeyValueStorageImpl(
    private val settings: FlowSettings
) : KeyValueStorage {

    override suspend fun updateItem(
        key: String,
        value: String,
    ): Either<Failure, Unit> = settings.putString(key, value).buildRight()

    override suspend fun observeItem(
        key: String
    ): Flow<String> = settings.getStringFlow(SORT_ORDER_KEY, defaultValue = EMPTY_VALUE)
}

private const val SORT_ORDER_KEY = "sortKey"
private const val EMPTY_VALUE = ""