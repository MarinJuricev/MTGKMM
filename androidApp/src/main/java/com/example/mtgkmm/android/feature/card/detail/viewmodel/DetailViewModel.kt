package com.example.mtgkmm.android.feature.card.detail.viewmodel

import com.example.mtgkmm.android.core.BaseViewModel
import com.example.mtgkmm.android.feature.card.detail.model.DetailEvent
import com.example.mtgkmm.android.feature.card.detail.model.DetailEvent.OnDetailOpened
import com.example.mtgkmm.android.feature.card.model.UiMtgCard

class DetailViewModel : BaseViewModel<DetailEvent>() {

    override fun onEvent(event: DetailEvent) {
        when (event) {
            is OnDetailOpened -> handleDetailOpened(event.mtgCard)
        }
    }

    private fun handleDetailOpened(mtgCard: UiMtgCard) {

    }
}