package com.example.mtgkmm.feature.search.data.repository

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Either.Left
import com.example.mtgkmm.core.Either.Right
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.buildRight
import com.example.mtgkmm.core.db.LocalMtgCard
import com.example.mtgkmm.feature.search.data.apiservice.CardApi
import com.example.mtgkmm.feature.search.data.local.CardStorage
import com.example.mtgkmm.feature.search.data.model.toDomain
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData
import com.example.mtgkmm.feature.search.domain.model.MtgStat
import com.example.mtgkmm.feature.search.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CardRepositoryImpl(
    private val cardApi: CardApi,
    private val cardStorage: CardStorage,
) : CardRepository {

    override suspend fun getCards(
        cardName: String,
    ): Either<Failure, MtgCardsData> =
        when (val apiResult = cardApi.getCard(cardName = cardName)) {
            is Right -> apiResult.value.toDomain().buildRight()
            is Left -> apiResult
        }

    override suspend fun saveCard(
        mtgCard: MtgCard,
    ): Either<Failure, Unit> = cardStorage.saveCard(mtgCard)

    override fun observeRecentlyViewedCards(): Flow<List<MtgCard>> =
        cardStorage.observeRecentlyViewedCards()
            .map { localCards ->
                localCards.map { it.toDomain() }
            }
}

private fun LocalMtgCard.toDomain(): MtgCard =
    //TODO Map correctly
    MtgCard(
        name = name,
        manaCost = manaCost,
        creature = creature,
        url = url,
        keywords = emptyList(),
        stat = MtgStat(0, 0),
        oracleText = oracleText,
        legalities = emptyList(),
        artist = artist,
    )