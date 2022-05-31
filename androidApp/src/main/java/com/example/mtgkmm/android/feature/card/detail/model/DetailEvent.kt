package com.example.mtgkmm.android.feature.card.detail.model

import com.example.mtgkmm.android.feature.card.model.UiMtgCard

sealed interface DetailEvent {
    data class OnDetailOpened(val mtgCard: UiMtgCard) : DetailEvent

}