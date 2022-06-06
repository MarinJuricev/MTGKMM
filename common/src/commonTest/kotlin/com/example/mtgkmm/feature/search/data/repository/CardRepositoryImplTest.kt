package com.example.mtgkmm.feature.search.data.repository

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.buildRight
import com.example.mtgkmm.core.db.LocalMtgCard
import com.example.mtgkmm.feature.search.data.apiservice.CardApi
import com.example.mtgkmm.feature.search.data.local.CardStorage
import com.example.mtgkmm.feature.search.data.model.network.NetworkCardsResponse
import com.example.mtgkmm.feature.search.domain.model.Legality
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.example.mtgkmm.feature.search.domain.model.MtgCreature
import com.example.mtgkmm.feature.search.domain.model.MtgKeyword
import com.example.mtgkmm.feature.search.domain.model.MtgStat
import com.example.mtgkmm.feature.search.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class CardRepositoryImplTest {

    private lateinit var sut: CardRepository

    @Test
    fun `getCards SHOULD return EitherRight WHEN cardApi returns Right`() = runBlocking {
        sut = CardRepositoryImpl(
            cardApi = TestCardApiSuccess(),
            cardStorage = TestCardStorage()
        )

        val result = sut.getCards(CARD_NAME)

        assertEquals(expected = Unit.buildRight(), actual = result)
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

private class TestCardStorage : CardStorage {

    private val items = mutableListOf<LocalMtgCard>()

    override suspend fun saveCard(
        card: MtgCard
    ): Either<Failure, Unit> = Unit.buildRight()

    override fun observeRecentlyViewedCards(): Flow<List<LocalMtgCard>> =
        flow {
            emit(items)
        }
}

private const val CARD_NAME = "name"
private const val MANA_COST = 2
private const val ORACLE_TEXT = "oracleText"
private const val ARTIST = "artist"
private const val URL = "url"
private val LEGALITIES = emptyList<Legality>()
private val CREATURE = MtgCreature.DRAGON
private val KEYWORDS = emptyList<MtgKeyword>()
private val STAT = MtgStat(2, 2)
