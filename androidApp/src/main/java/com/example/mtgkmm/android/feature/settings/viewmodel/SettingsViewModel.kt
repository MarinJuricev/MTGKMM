package com.example.mtgkmm.android.feature.settings.viewmodel

import com.example.mtgkmm.android.core.BaseViewModel
import com.example.mtgkmm.android.feature.settings.model.SettingsEvent
import com.example.mtgkmm.feature.settings.domain.usecase.ObserveSettingsData
import com.example.mtgkmm.feature.settings.domain.usecase.SetSortType

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
