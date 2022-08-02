package com.example.mtgkmm.android.feature.settings.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.mtgkmm.android.core.BaseViewModel
import com.example.mtgkmm.android.core.TIMEOUT_DELAY
import com.example.mtgkmm.android.core.components.topbar.TopBarViewState
import com.example.mtgkmm.android.feature.settings.model.SettingsEvent
import com.example.mtgkmm.android.feature.settings.model.SettingsEvent.OnChangeSortType
import com.example.mtgkmm.android.feature.settings.model.SettingsEvent.OnGetSettingsData
import com.example.mtgkmm.feature.settings.domain.model.SettingsItem
import com.example.mtgkmm.feature.settings.domain.usecase.ObserveSettingsData
import com.example.mtgkmm.feature.settings.domain.usecase.UpdateSortType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val observeSettingsData: ObserveSettingsData,
    private val updateSortType: UpdateSortType,
) : BaseViewModel<SettingsEvent>() {

    private val settingItems = MutableStateFlow(emptyList<SettingsItem>())
    val state = settingItems.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(TIMEOUT_DELAY),
        initialValue = emptyList(),
    )

    override fun onEvent(event: SettingsEvent) {
        when (event) {
            OnGetSettingsData -> handleGetSettingsData()
            is OnChangeSortType -> handleChangeSortType(event.updatedSortType)
        }
    }

    private fun handleGetSettingsData() = observeSettingsData()
        .onEach { settingItems.update { it } }
        .launchIn(viewModelScope)

    private fun handleChangeSortType(
        updatedSortType: String,
    ) = viewModelScope.launch {
        updateSortType(updatedSortType)
    }
}
