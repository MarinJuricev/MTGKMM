package com.example.mtgkmm.android.feature.card.detail.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.mtgkmm.android.core.BaseViewModel
import com.example.mtgkmm.android.feature.card.detail.model.DetailEvent
import com.example.mtgkmm.android.feature.card.detail.model.DetailEvent.OnDetailOpened
import com.example.mtgkmm.android.feature.card.model.UiMtgCard
import com.example.mtgkmm.android.feature.card.model.toDomain
import com.example.mtgkmm.feature.search.domain.usecase.SaveCard
import kotlinx.coroutines.launch

class DetailViewModel(private val saveCard: SaveCard) : BaseViewModel<DetailEvent>() {

    override fun onEvent(event: DetailEvent) {
        when (event) {
            is OnDetailOpened -> handleDetailOpened(event.mtgCard)
        }
    }

    private fun handleDetailOpened(mtgCard: UiMtgCard) =
        viewModelScope.launch { saveCard(mtgCard.toDomain()) }
}
