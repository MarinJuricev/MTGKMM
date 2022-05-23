package com.example.mtgkmm.android.search.di

import com.example.mtgkmm.android.search.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchPresentationModule = module {
    viewModel {
        SearchViewModel(
            getCards = get(),
            navigator = get(),
        )
    }
}