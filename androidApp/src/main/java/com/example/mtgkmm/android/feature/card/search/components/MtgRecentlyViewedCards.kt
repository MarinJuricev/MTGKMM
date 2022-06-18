package com.example.mtgkmm.android.feature.card.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.mtgkmm.android.R
import com.example.mtgkmm.android.core.components.MtgAsyncImage
import com.example.mtgkmm.android.feature.card.model.UiMtgCard
import com.example.mtgkmm.android.feature.card.search.model.SearchEvent

@Composable
fun MtgRecentlyViewedCards(
    recentlyViewedCards: List<UiMtgCard>,
    onEvent: (SearchEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.margin_small)),
            text = stringResource(id = R.string.recently_viewed),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_small)))
        LazyRow(
            modifier = modifier,
        ) {
            items(recentlyViewedCards, key = { mtgCard -> mtgCard.name }) { mtgCard ->
                MtgAsyncImage(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(dimensionResource(id = R.dimen.margin_small))
                        .clickable { onEvent(SearchEvent.OnCardClick(mtgCard)) },
                    url = mtgCard.url,
                    contentDescription = mtgCard.name,
                )
            }
        }
    }
}