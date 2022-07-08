package com.example.mtgkmm.android.feature.settings.viewmodel

import com.example.mtgkmm.android.core.BaseViewModel
import com.example.mtgkmm.android.feature.settings.model.SettingsEvent

class SettingsViewModel(
    private val observeSettingsData: ObserveSettingsData,
    private val setSortType: SetSortType,
) : BaseViewModel<SettingsEvent>() {

    override fun onEvent(event: SettingsEvent) {
        when (event) {
            is SettingsEvent.OnChangeSortType -> TODO()
            SettingsEvent.OnGetSettingsData -> TODO()
        }
    }
}
