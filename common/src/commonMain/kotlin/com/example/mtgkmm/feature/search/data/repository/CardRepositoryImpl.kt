package com.example.mtgkmm.feature.search.data.repository

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Either.Left
import com.example.mtgkmm.core.Either.Right
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.buildRight
import com.example.mtgkmm.feature.search.data.apiservice.CardApi
import com.example.mtgkmm.feature.search.data.model.toDomain
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData
import com.example.mtgkmm.feature.search.domain.repository.CardRepository

class CardRepositoryImpl(
    private val cardApi: CardApi,
) : CardRepository {

    override suspend fun getCards(
        cardName: String
    ): Either<Failure, MtgCardsData> =
        when (val apiResult = cardApi.getCard(cardName = cardName)) {
            is Right -> apiResult.value.toDomain().buildRight()
            is Left -> apiResult
        }
}