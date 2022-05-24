package com.example.mtgkmm.android.feature.card.search.model

import com.example.mtgkmm.feature.search.domain.model.MtgCardsData

data class SearchState(
    val isLoading: Boolean = false,
    val currentSearch: String = "",
    val error: String? = null,
    val data: MtgCardsData? = null,
)
