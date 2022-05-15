package com.example.mtgkmm.feature.search.data.model


import com.example.mtgkmm.core.ext.orEmpty
import com.example.mtgkmm.core.ext.orFalse
import com.example.mtgkmm.core.ext.orZero
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData
import com.example.mtgkmm.feature.search.domain.model.MtgCreature
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

//TODO map url correctly
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
                    keywords = emptyList(),
                    stat = MtgStat(
                        power = power.orZero(),
                        toughness = toughness.orZero(),
                    ),
                    oracleText = oracleText.orEmpty(),
                    legalities = emptyList(),
                    artist = artist.orEmpty()
                )
            }
        } ?: emptyList()
    )
