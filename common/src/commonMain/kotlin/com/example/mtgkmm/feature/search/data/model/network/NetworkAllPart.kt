package com.example.mtgkmm.feature.search.data.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkAllPart(
    val component: String?,
    val id: String?,
    val name: String?,
    @SerialName("object") val objectType: String?,
    @SerialName("type_line") val typeLine: String?,
    val uri: String?
)
