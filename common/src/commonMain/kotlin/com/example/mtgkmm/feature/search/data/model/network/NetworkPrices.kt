package com.example.mtgkmm.feature.search.data.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPrices(
    val eur: String?,
    @SerialName("eur_foil") val eurFoil: String?,
    val tix: String?,
    val usd: String?,
    @SerialName("usd_etched") val usdEtched: String?,
    @SerialName("usd_foil") val usdFoil: String?
)
