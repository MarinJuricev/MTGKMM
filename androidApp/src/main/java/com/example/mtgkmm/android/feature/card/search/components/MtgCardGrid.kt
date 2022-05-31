package com.example.mtgkmm.android.feature.card.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mtgkmm.android.core.MtgAsyncImage
import com.example.mtgkmm.android.feature.card.model.UiMtgCard
import com.example.mtgkmm.android.feature.card.search.model.SearchEvent
import com.example.mtgkmm.android.feature.card.search.model.SearchEvent.OnCardClick

@Composable
fun MtgCardGrid(
    cards: List<UiMtgCard>,
    onEvent: (SearchEvent) -> Unit,
) {
    LazyVerticalGrid(columns = GridCells.Fixed(GRID_COUNT)) {
        items(cards, key = { mtgCard -> mtgCard.name }) { mtgCard ->
            MtgAsyncImage(
                modifier = Modifier
                    .size(256.dp)
                    .padding(8.dp)
                    .clickable { onEvent(OnCardClick(mtgCard)) },
                url = mtgCard.url,
                contentDescription = mtgCard.name,
            )
        }
    }
}

private const val GRID_COUNT = 2