package com.example.mtgkmm.android.feature.card.detail.di

import com.example.mtgkmm.android.feature.card.detail.viewmodel.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailPresentationModule = module {
    viewModel {
        DetailViewModel(
            saveCard = get()
        )
    }
}