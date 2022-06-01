package com.example.mtgkmm.feature.search.data.model


import com.example.mtgkmm.core.ext.orEmpty
import com.example.mtgkmm.core.ext.orFalse
import com.example.mtgkmm.core.ext.orZero
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData
import com.example.mtgkmm.feature.search.domain.model.MtgCreature
import com.example.mtgkmm.feature.search.domain.model.MtgKeyword
import com.example.mtgkmm.feature.search.domain.model.MtgStat
import com.example.mtgkmm.feature.search.domain.model.Pagination
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCardsResponse(
    val data: List<NetworkCardData>?,
    @SerialName("has_more")
    val hasMore: Boolean?,
    @SerialName("next_page")
    val nextPage: String?,
    @SerialName("object")
    val objectType: String?,
    @SerialName("total_cards")
    val totalCards: Int?
)

fun NetworkCardsResponse.toDomain(): MtgCardsData =
    MtgCardsData(
        pagination = Pagination(
            totalCards = totalCards.orEmpty(),
            hasMore = hasMore.orFalse(),
            nextPage = nextPage.orEmpty(),
        ),
        cards = data?.map { networkCardData ->
            with(networkCardData) {
                MtgCard(
                    name = name.orEmpty(),
                    manaCost = manaCost.orZero(),
                    creature = MtgCreature.DRAGON,
                    url = imageUris?.png.orEmpty(),
                    keywords = keywords?.toKeywordDomain() ?: emptyList(),
                    stat = MtgStat(
                        power = power.orZero(),
                        toughness = toughness.orZero(),
                    ),
                    oracleText = oracleText.orEmpty(),
                    legalities = emptyList(), //TODO Parse this
                    artist = artist.orEmpty()
                )
            }
        } ?: emptyList()
    )

private fun List<String>.toKeywordDomain(): List<MtgKeyword> =
    map { keyword ->
        when (keyword.lowercase()) {
            "deathtouch" -> MtgKeyword.DEATH_TOUCH
            "first strike" -> MtgKeyword.FIRST_STRIKE
            "soulbound" -> MtgKeyword.SOUL_BOUND
            "equip" -> MtgKeyword.EQUIP
            "flying" -> MtgKeyword.FLYING
            "transform" -> MtgKeyword.TRANSFORM
            "mill" -> MtgKeyword.MILL
            "ward" -> MtgKeyword.WARD
            "rally" -> MtgKeyword.RALLY
            "menace" -> MtgKeyword.MENACE
            "megamorph" -> MtgKeyword.MEGA_MORPH
            "lifelink" -> MtgKeyword.LIFE_LINK
            "haste" -> MtgKeyword.HASTE
            else -> MtgKeyword.UNKNOWN
        }
    }