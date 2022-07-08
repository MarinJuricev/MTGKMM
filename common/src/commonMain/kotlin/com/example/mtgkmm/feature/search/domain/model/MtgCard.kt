package com.example.mtgkmm.feature.search.domain.model

data class MtgCard(
    val name: String,
    val manaCost: Int,
    val creature: MtgCreature,
    val url: String,
    val keywords: List<MtgKeyword>,
    val stat: MtgStat,
    val oracleText: String,
    val legalities: List<Legality>,
    val artist: String,
)
