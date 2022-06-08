package com.example.mtgkmm.feature.search.domain.usecase

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.buildLeft
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData
import com.example.mtgkmm.feature.search.domain.model.MtgCreature
import com.example.mtgkmm.feature.search.domain.model.MtgStat
import com.example.mtgkmm.feature.search.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SaveCardTest {

    private lateinit var sut: SaveCard

    @BeforeTest
    fun setUp() {
        sut = SaveCard(
            cardRepository = SaveCardFailureCardRepository()
        )
    }

    @Test
    fun `invoke SHOULD return result from cardRepository getCards`() = runTest {
        val mtgCard = buildMtgCard()

        val result = sut(mtgCard)

        assertEquals(expected = Failure.UnknownError.buildLeft(), actual = result)
    }

    private fun buildMtgCard(): MtgCard = MtgCard(
        name = "",
        manaCost = 0,
        creature = MtgCreature.DRAGON,
        url = "",
        keywords = emptyList(),
        stat = MtgStat(0, 0),
        oracleText = "",
        legalities = emptyList(),
        artist = ""
    )
}

private class SaveCardFailureCardRepository : CardRepository {
    override suspend fun getCards(cardName: String): Either<Failure, MtgCardsData> {
        TODO("Not yet implemented")
    }

    override suspend fun saveCard(mtgCard: MtgCard): Either<Failure, Unit> {
        return Failure.UnknownError.buildLeft()
    }

    override fun observeRecentlyViewedCards(): Flow<List<MtgCard>> {
        TODO("Not yet implemented")
    }

}
