package com.example.mtgkmm.android.feature.card.model

import com.example.mtgkmm.feature.search.domain.model.MtgCardsData

data class UiMtgCardsData(val pagination: UiPagination, val cards: List<UiMtgCard>)

fun MtgCardsData.toUi(): UiMtgCardsData =
    UiMtgCardsData(pagination = pagination.toUi(), cards = cards.map { card -> card.toUi() })
