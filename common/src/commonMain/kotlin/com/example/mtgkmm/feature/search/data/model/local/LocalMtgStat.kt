package com.example.mtgkmm.feature.search.data.model.local

import com.example.mtgkmm.feature.search.domain.model.MtgStat

@kotlinx.serialization.Serializable
data class LocalMtgStat(
    val power: Int,
    val toughness: Int,
)

fun LocalMtgStat.toDomain(): MtgStat =
    MtgStat(
        power,
        toughness
    )
