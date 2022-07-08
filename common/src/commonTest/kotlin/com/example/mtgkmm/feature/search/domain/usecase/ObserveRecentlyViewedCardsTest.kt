package com.example.mtgkmm.feature.search.domain.usecase

import app.cash.turbine.test
import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData
import com.example.mtgkmm.feature.search.domain.model.MtgCreature
import com.example.mtgkmm.feature.search.domain.model.MtgStat
import com.example.mtgkmm.feature.search.domain.repository.CardRepository
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest

class ObserveRecentlyViewedCardsTest {

    private lateinit var sut: ObserveRecentlyViewedCards

    @BeforeTest
    fun setUp() {
        sut = ObserveRecentlyViewedCards(cardRepository = FakeCardRepository())
    }

    @Test
    fun `invoke SHOULD return result from cardRepository getCards`() = runTest {
        val expectedResult = listOf(buildMtgCard())

        sut().test {
            assertEquals(expectedResult, awaitItem())
            awaitComplete()
        }
    }

    private inner class FakeCardRepository : CardRepository {
        override suspend fun getCards(cardName: String): Either<Failure, MtgCardsData> {
            TODO("Not yet implemented")
        }

        override suspend fun saveCard(mtgCard: MtgCard): Either<Failure, Unit> {
            TODO("Not yet implemented")
        }

        override fun observeRecentlyViewedCards(): Flow<List<MtgCard>> = flow {
            emit(listOf(buildMtgCard()))
        }
    }
}

private fun buildMtgCard(): MtgCard =
    MtgCard(
        name = "",
        manaCost = 0,
        creature = MtgCreature.DRAGON,
        url = "",
        keywords = emptyList(),
        stat = MtgStat(0, 0),
        oracleText = "",
        legalities = emptyList(),
        artist = "",
    )
