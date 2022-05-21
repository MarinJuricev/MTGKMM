package com.example.mtgkmm.android.search.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mtgkmm.android.core.MtgAsyncImage
import com.example.mtgkmm.feature.search.domain.model.MtgCard

@Composable
fun MtgCardGrid(cards: List<MtgCard>) {
    LazyVerticalGrid(columns = GridCells.Fixed(GRID_COUNT)) {
        items(cards, key = { mtgCard -> mtgCard.name }) { mtgCard ->
            MtgAsyncImage(
                modifier = Modifier
                    .size(256.dp)
                    .padding(8.dp),
                url = mtgCard.url,
                contentDescription = mtgCard.name,
            )
        }
    }
}

private const val GRID_COUNT = 2