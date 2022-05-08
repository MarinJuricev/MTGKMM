package com.example.mtgkmm.feature.search.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPrices(
    val eur: String?,
    @SerialName("eur_foil")
    val eurFoil: String?,
    val tix: String?,
    val usd: String?,
    @SerialName("usd_etched")
    val usdEtched: Any?, // TODO What is this field ?
    @SerialName("usd_foil")
    val usdFoil: String?
)