package com.example.mtgkmm.feature.settings.data.storage

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.buildRight
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set
import kotlinx.coroutines.flow.Flow

class KeyValueStorageImpl(
    private val settings: Settings
) : KeyValueStorage {

    override suspend fun updateItem(
        key: String,
        value: String,
    ): Either<Failure, Unit> = settings.set(key, value).buildRight()

    override suspend fun observeItem(
        key: String
    ): Flow<String> {
        settings.ls
        settings.get
    }
}