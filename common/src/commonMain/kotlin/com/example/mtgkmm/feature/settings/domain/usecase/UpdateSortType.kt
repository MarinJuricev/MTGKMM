package com.example.mtgkmm.feature.settings.domain.usecase

import SettingsRepository

class UpdateSortType(
    private val settingsRepository: SettingsRepository,
) {
    suspend operator fun invoke(updatedSortType: String) =
        settingsRepository.updateSort(updatedSortType)

}