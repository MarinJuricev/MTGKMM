package com.example.mtgkmm.android.feature.card.model

import android.os.Parcelable
import com.example.mtgkmm.feature.search.domain.model.MtgStat
import kotlinx.parcelize.Parcelize

@Parcelize
@kotlinx.serialization.Serializable
data class UiMtgStat(
    val power: Int,
    val toughness: Int,
) : Parcelable

fun MtgStat.toUi(): UiMtgStat = UiMtgStat(
    power = power,
    toughness = toughness,
)
