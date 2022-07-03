package com.example.mtgkmm.android.feature.card.search.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import com.example.mtgkmm.android.R
import com.example.mtgkmm.android.feature.card.search.model.SearchEvent
import com.example.mtgkmm.android.feature.card.search.model.SearchState

@Composable
fun MtgSearchTopBar(state: SearchState, onEvent: (SearchEvent) -> Unit) {
    TopAppBar {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
            TextField(
                modifier = Modifier.fillMaxWidth().scale(scaleY = 0.9F, scaleX = 1F),
                value = state.currentSearch,
                label = { Text(text = stringResource(id = R.string.search)) },
                colors =
                TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    textColor = MaterialTheme.colors.primary
                ),
                onValueChange = { newSearch -> onEvent(SearchEvent.OnSearchUpdate(newSearch)) }
            )
        }
    }
}
