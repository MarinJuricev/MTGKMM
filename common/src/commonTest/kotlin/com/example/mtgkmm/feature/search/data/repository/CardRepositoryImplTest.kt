package com.example.mtgkmm.feature.search.data.repository

import app.cash.turbine.test
import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.buildLeft
import com.example.mtgkmm.core.buildRight
import com.example.mtgkmm.core.db.LocalMtgCard
import com.example.mtgkmm.feature.search.data.apiservice.CardApi
import com.example.mtgkmm.feature.search.data.local.CardStorage
import com.example.mtgkmm.feature.search.data.model.local.toLocal
import com.example.mtgkmm.feature.search.data.model.network.NetworkCardsResponse
import com.example.mtgkmm.feature.search.data.model.network.toDomain
import com.example.mtgkmm.feature.search.domain.model.Legality
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.example.mtgkmm.feature.search.domain.model.MtgCreature
import com.example.mtgkmm.feature.search.domain.model.MtgKeyword
import com.example.mtgkmm.feature.search.domain.model.MtgStat
import com.example.mtgkmm.feature.search.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CardRepositoryImplTest {

    private lateinit var sut: CardRepository

    @Test
    fun `getCards SHOULD return EitherRight WHEN cardApi returns Right`() = runTest {
        sut = CardRepositoryImpl(
            cardApi = TestCardApiSuccess(),
            cardStorage = TestCardStorage()
        )
        val expectedResult = NetworkCardsResponse(
            data = null,
            hasMore = null,
            nextPage = null,
            objectType = null,
            totalCards = null,
        ).toDomain().buildRight()

        val result = sut.getCards(CARD_NAME)

        assertEquals(expected = expectedResult, actual = result)
    }

    @Test
    fun `getCards SHOULD return EitherLeft WHEN cardApi returns Left`() = runTest {
        sut = CardRepositoryImpl(
            cardApi = TestCardApiFailure(),
            cardStorage = TestCardStorage()
        )
        val expectedResult = Failure.UnknownError.buildLeft()

        val result = sut.getCards(CARD_NAME)

        assertEquals(expected = expectedResult, actual = result)
    }

    @Test
    fun `saveCard SHOULD return result from cardStorage saveCard`() = runTest {
        sut = CardRepositoryImpl(
            cardApi = TestCardApiFailure(),
            cardStorage = TestCardStorage()
        )
        val expectedResult = Unit.buildRight()
        val mtgCard = buildMtgCard()

        val result = sut.saveCard(mtgCard)

        assertEquals(expected = expectedResult, actual = result)
    }

    @Test
    fun `observeRecentlyViewedCards SHOULD return two items when we saveCard is called twice`() =
        runTest {
            sut = CardRepositoryImpl(
                cardApi = TestCardApiFailure(),
                cardStorage = TestCardStorage()
            )
            val expectedResult = listOf(buildMtgCard())

            sut.observeRecentlyViewedCards().test {
                assertEquals(expectedResult, awaitItem())
                awaitComplete()
            }
        }
}

private class TestCardApiSuccess : CardApi {

    override suspend fun getCard(
        cardName: String
    ): Either<Failure, NetworkCardsResponse> =
        NetworkCardsResponse(
            data = null,
            hasMore = null,
            nextPage = null,
            objectType = null,
            totalCards = null,
        ).buildRight()

}

private class TestCardApiFailure : CardApi {

    override suspend fun getCard(
        cardName: String
    ): Either<Failure, NetworkCardsResponse> =
        Failure.UnknownError.buildLeft()

}

private class TestCardStorage : CardStorage {

    private val items = mutableListOf(buildMtgCard().toLocal())

    override suspend fun saveCard(
        card: MtgCard
    ): Either<Failure, Unit> = Unit.buildRight()

    override fun observeRecentlyViewedCards(): Flow<List<LocalMtgCard>> =
        flow {
            emit(items)
        }
}

private fun MtgCard.toLocal(): LocalMtgCard =
    LocalMtgCard(
        name = name,
        manaCost = manaCost,
        creature = creature,
        url = url,
        keywords = keywords,
        stat = stat.toLocal(),
        oracleText = oracleText,
        legalities = "",
        artist = artist,
    )

private fun buildMtgCard(): MtgCard =
    MtgCard(
        CARD_NAME,
        MANA_COST,
        CREATURE,
        URL,
        KEYWORDS,
        STAT,
        ORACLE_TEXT,
        LEGALITIES,
        ARTIST
    )

private const val CARD_NAME = "name"
private const val MANA_COST = 2
private const val ORACLE_TEXT = "oracleText"
private const val ARTIST = "artist"
private const val URL = "url"
private val LEGALITIES = emptyList<Legality>()
private val CREATURE = MtgCreature.DRAGON
private val KEYWORDS = emptyList<MtgKeyword>()
private val STAT = MtgStat(2, 2)
