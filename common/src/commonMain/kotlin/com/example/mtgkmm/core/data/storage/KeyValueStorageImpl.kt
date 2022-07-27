package com.example.mtgkmm.core.data.storage

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.buildRight
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.FlowSettings
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalSettingsApi::class)
class KeyValueStorageImpl(
    private val settings: FlowSettings
) : KeyValueStorage {

    override suspend fun updateItem(
        key: String,
        value: String,
    ): Either<Failure, Unit> = settings.putString(key, value).buildRight()

    override fun observeItem(
        key: String
    ): Flow<String> = settings.getStringFlow(SORT_ORDER_KEY, defaultValue = EMPTY_VALUE)
}

private const val SORT_ORDER_KEY = "sortKey"
private const val EMPTY_VALUE = ""