package com.example.mtgkmm.android.feature.card.model

import com.example.mtgkmm.feature.search.domain.model.MtgStat

data class UiMtgCard(
    val name: String,
    val manaCost: Int,
    val creature: UiMtgCreature,
    val url: String,
    val keywords: List<UiMtgKeyword>,
    val stat: MtgStat,
    val oracleText: String,
    val legalities: List<UiLegality>,
    val artist: String,
)
