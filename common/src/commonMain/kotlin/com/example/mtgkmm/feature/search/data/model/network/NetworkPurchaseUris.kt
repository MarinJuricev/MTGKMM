package com.example.mtgkmm.feature.search.data.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPurchaseUris(
    @SerialName("cardhoarder") val cardHoarder: String?,
    @SerialName("cardmarket") val cardMarket: String?,
    @SerialName("tcgplayer") val tcgPlayer: String?,
)
