package com.example.mtgkmm.feature.search.data.model.network


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkLegalities(
    val alchemy: String?,
    val brawl: String?,
    val commander: String?,
    val duel: String?,
    val explorer: String?,
    val future: String?,
    val gladiator: String?,
    val historic: String?,
    @SerialName("historicbrawl")
    val historicBrawl: String?,
    val legacy: String?,
    val modern: String?,
    val oldSchool: String?,
    val pauper: String?,
    @SerialName("paupercommander")
    val pauperCommander: String?,
    val penny: String?,
    val pioneer: String?,
    @SerialName("premodern")
    val preModern: String?,
    val standard: String?,
    val vintage: String?
)