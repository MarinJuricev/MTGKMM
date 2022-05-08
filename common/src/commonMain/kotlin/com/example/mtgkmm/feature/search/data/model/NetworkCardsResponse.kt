package com.example.mtgkmm.feature.search.data.model


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