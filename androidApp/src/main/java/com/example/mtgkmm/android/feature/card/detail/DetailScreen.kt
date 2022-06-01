package com.example.mtgkmm.android.feature.card.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.mtgkmm.android.core.navigation.LocalTopBarEvents
import com.example.mtgkmm.android.core.components.topbar.TopBarViewState
import com.example.mtgkmm.android.core.components.topbar.model.TopBarEvent.OnTopBarChange
import com.example.mtgkmm.android.feature.card.detail.model.DetailEvent.OnDetailOpened
import com.example.mtgkmm.android.feature.card.detail.viewmodel.DetailViewModel
import com.example.mtgkmm.android.feature.card.model.UiMtgCard

@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
    mtgCard: UiMtgCard,
) {
    val topBarEvent = LocalTopBarEvents.current

    LaunchedEffect(key1 = Unit) {
        topBarEvent?.invoke(OnTopBarChange(TopBarViewState()))

        viewModel.onEvent(OnDetailOpened(mtgCard))
    }

    Text(text = mtgCard.name)
}