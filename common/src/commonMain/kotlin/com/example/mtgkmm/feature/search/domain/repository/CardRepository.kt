package com.example.mtgkmm.feature.search.domain.repository

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData

interface CardRepository {
    suspend fun getCards(
        cardName: String
    ): Either<Failure, MtgCardsData>
}