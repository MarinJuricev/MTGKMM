package com.example.mtgkmm.feature.search.data.repository

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.feature.search.data.apiservice.CardApi
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData
import com.example.mtgkmm.feature.search.domain.repository.CardRepository

class CardRepositoryImpl(
    private val cardApi: CardApi,
): CardRepository {

    override suspend fun getCards(
        cardName: String
    ): Either<Failure, MtgCardsData> {
        TODO("Not yet implemented")
    }
}