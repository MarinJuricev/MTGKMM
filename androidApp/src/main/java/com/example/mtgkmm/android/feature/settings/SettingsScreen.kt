package com.example.mtgkmm.android.feature.settings

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.mtgkmm.android.feature.settings.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(viewModel: SettingsViewModel) {
    OutlinedTextField(value = "Map an Sort type", placeholder = { Text("Sort") }, onValueChange = {})
}
