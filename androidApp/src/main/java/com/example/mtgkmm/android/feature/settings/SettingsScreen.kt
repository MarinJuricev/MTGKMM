package com.example.mtgkmm.android.feature.settings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.mtgkmm.android.feature.settings.model.SettingsEvent.OnChangeSortType
import com.example.mtgkmm.android.feature.settings.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel
) {

    val state by viewModel.state.collectAsState()

    LazyColumn {
        items(state, key = { it.id }) { settingsItem ->
            SettingsItem(
                value = settingsItem.value,
                placeholderText = settingsItem.name,

                onValueChanged = {
                    viewModel.onEvent(OnChangeSortType(it))
                }
            )
        }
    }

}

@Preview
@Composable
private fun SettingsItem(
    value: String,
    placeholderText: String,
    onValueChanged: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        placeholder = { Text(placeholderText) },
        onValueChange = onValueChanged
    )
}
