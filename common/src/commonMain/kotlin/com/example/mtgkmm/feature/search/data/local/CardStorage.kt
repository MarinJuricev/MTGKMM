package com.example.mtgkmm.feature.search.data.local

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.db.LocalMtgCard
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import kotlinx.coroutines.flow.Flow

interface CardStorage {
    suspend fun saveCard(card: MtgCard): Either<Failure, Unit>
    fun observeRecentlyViewedCards(): Flow<List<LocalMtgCard>>
}