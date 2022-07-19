package com.example.mtgkmm.feature.settings.data.storage

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import kotlinx.coroutines.flow.Flow

interface KeyValueStorage {

    suspend fun updateItem(key: String, value: String): Either<Failure, Unit>

    suspend fun observeItem(key: String): Flow<String>
}