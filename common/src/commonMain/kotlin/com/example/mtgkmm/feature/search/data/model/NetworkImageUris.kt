package com.example.mtgkmm.feature.search.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkImageUris(
    @SerialName("art_crop")
    val artCrop: String?,
    @SerialName("border_crop")
    val borderCrop: String?,
    val large: String?,
    val normal: String?,
    val png: String?,
    val small: String?
)