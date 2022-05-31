package com.example.mtgkmm.feature.search.domain.repository

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    suspend fun getCards(
        cardName: String
    ): Either<Failure, MtgCardsData>

    suspend fun saveCard(
        mtgCard: MtgCard
    ): Either<Failure, Unit>

    fun observeRecentlyViewedCards(): Flow<List<MtgCard>>
}