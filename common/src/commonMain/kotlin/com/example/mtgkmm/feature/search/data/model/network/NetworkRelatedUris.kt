package com.example.mtgkmm.feature.search.data.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkRelatedUris(
    val edhrec: String?,
    val gatherer: String?,
    val mtgtop8: String?,
    @SerialName("tcgplayer_infinite_articles") val tcgPlayerInfiniteArticles: String?,
    @SerialName("tcgplayer_infinite_decks") val tcgPlayerInfiniteDecks: String?,
)
