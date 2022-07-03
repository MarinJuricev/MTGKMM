package com.example.mtgkmm.feature.search.domain.usecase

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.buildLeft
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData
import com.example.mtgkmm.feature.search.domain.repository.CardRepository
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.test.runTest

class GetCardsTest {

    private lateinit var sut: GetCards

    @BeforeTest
    fun setUp() {
        sut = GetCards(cardRepository = FakeCardRepository())
    }

    @Test
    fun `invoke SHOULD return result from cardRepository getCards`() = runTest {
        val result = sut(CARD_NAME)

        assertEquals(expected = Failure.UnknownError.buildLeft(), actual = result)
    }

    private inner class FakeCardRepository : CardRepository {
        override suspend fun getCards(cardName: String): Either<Failure, MtgCardsData> {
            return Failure.UnknownError.buildLeft()
        }

        override suspend fun saveCard(mtgCard: MtgCard): Either<Failure, Unit> {
            TODO("Not yet implemented")
        }

        override fun observeRecentlyViewedCards(): Flow<List<MtgCard>> {
            TODO("Not yet implemented")
        }
    }
}

private const val CARD_NAME = "cardName"
