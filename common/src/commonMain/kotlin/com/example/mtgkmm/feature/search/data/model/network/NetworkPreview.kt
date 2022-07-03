package com.example.mtgkmm.feature.search.data.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPreview(
    @SerialName("previewed_at") val previewedAt: String?,
    val source: String?,
    @SerialName("source_uri") val sourceUri: String?
)
