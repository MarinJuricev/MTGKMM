package com.example.mtgkmm.android.feature.card.search.di

import com.example.mtgkmm.android.feature.card.search.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchPresentationModule = module {
    viewModel {
        SearchViewModel(
            getCards = get(),
            observeRecentlyViewedCards = get(),
            navigator = get(),
        )
    }
}