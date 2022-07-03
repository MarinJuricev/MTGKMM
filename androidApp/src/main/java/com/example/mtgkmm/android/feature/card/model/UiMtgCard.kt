package com.example.mtgkmm.android.feature.card.model

import android.os.Parcelable
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.example.mtgkmm.feature.search.domain.model.MtgCreature
import com.example.mtgkmm.feature.search.domain.model.MtgKeyword
import kotlinx.parcelize.Parcelize

@Parcelize
@kotlinx.serialization.Serializable
data class UiMtgCard(
    val name: String,
    val manaCost: Int,
    val creature: MtgCreature,
    val url: String,
    val keywords: List<MtgKeyword>,
    val stat: UiMtgStat,
    val oracleText: String,
    val legalities: List<UiLegality>,
    val artist: String
) : Parcelable

fun MtgCard.toUi(): UiMtgCard =
    UiMtgCard(
        name = name,
        manaCost = manaCost,
        creature = creature,
        url = url,
        keywords = keywords,
        stat = stat.toUi(),
        oracleText = oracleText,
        legalities = emptyList(),
        artist = artist
    )

fun UiMtgCard.toDomain(): MtgCard =
    MtgCard(
        name = name,
        manaCost = manaCost,
        creature = creature,
        url = url,
        keywords = keywords,
        stat = stat.toDomain(),
        oracleText = oracleText,
        legalities = emptyList(),
        artist = artist
    )
