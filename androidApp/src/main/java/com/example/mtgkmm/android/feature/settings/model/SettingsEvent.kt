package com.example.mtgkmm.android.feature.settings.model

sealed interface SettingsEvent {
    object OnGetSettingsData: SettingsEvent
    data class OnChangeSortType(val updatedSortType: String): SettingsEvent
}
