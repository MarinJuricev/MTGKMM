package com.example.mtgkmm.feature.search.di

import com.example.mtgkmm.feature.search.domain.usecase.GetCards
import org.koin.dsl.module

val searchModule = module {
    factory {
        GetCards(
            cardRepository = get(),
        )
    }
}