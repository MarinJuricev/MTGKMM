package com.example.mtgkmm.android.search.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.mtgkmm.android.R
import com.example.mtgkmm.android.search.model.SearchEvent
import com.example.mtgkmm.android.search.model.SearchState

@Composable
fun MtgSearchTopBar(
    state: SearchState,
    onEvent: (SearchEvent) -> Unit,
) {
    TopAppBar {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterStart,
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.currentSearch,
                label = { Text(text = stringResource(id = R.string.search)) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    textColor = MaterialTheme.colors.primary,
                ),
                onValueChange = { newSearch ->
                    onEvent(SearchEvent.OnSearchUpdate(newSearch))
                }
            )
        }
    }
}

