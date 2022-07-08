package com.example.mtgkmm.feature.search.data.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCardFace(
    val artist: String?,
    @SerialName("artist_id") val artistId: String?,
    @SerialName("color_indicator") val colorIndicator: List<String>?,
    val colors: List<String>?,
    @SerialName("flavor_name") val flavorName: String?,
    @SerialName("flavor_text") val flavorText: String?,
    @SerialName("illustration_id") val illustrationId: String?,
    @SerialName("image_uris") val imageUris: NetworkImageUris?,
    @SerialName("mana_cost") val manaCost: String?,
    val name: String?,
    val objectType: String?,
    @SerialName("oracle_text") val oracleText: String?,
    val power: String?,
    val toughness: String?,
    @SerialName("type_line") val typeLine: String?,
)
