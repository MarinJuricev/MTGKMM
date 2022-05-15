package com.example.mtgkmm.feature.search.di

import com.example.mtgkmm.feature.search.data.apiservice.CardApi
import com.example.mtgkmm.feature.search.data.apiservice.CardApiImpl
import com.example.mtgkmm.feature.search.data.repository.CardRepositoryImpl
import com.example.mtgkmm.feature.search.domain.repository.CardRepository
import com.example.mtgkmm.feature.search.domain.usecase.GetCards
import org.koin.dsl.module

val searchModule = module {
    factory<CardApi> {
        CardApiImpl(
            client = get(),
        )
    }

    factory<CardRepository> {
        CardRepositoryImpl(
            cardApi = get(),
        )
    }

    factory {
        GetCards(
            cardRepository = get(),
        )
    }
}