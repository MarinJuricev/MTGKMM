package com.example.mtgkmm.feature.search.di

import com.example.mtgkmm.core.db.MtgKmmDatabase
import com.example.mtgkmm.feature.search.data.apiservice.CardApi
import com.example.mtgkmm.feature.search.data.apiservice.CardApiImpl
import com.example.mtgkmm.feature.search.data.local.CardStorage
import com.example.mtgkmm.feature.search.data.local.CardStorageImpl
import com.example.mtgkmm.feature.search.data.repository.CardRepositoryImpl
import com.example.mtgkmm.feature.search.domain.repository.CardRepository
import com.example.mtgkmm.feature.search.domain.usecase.GetCards
import com.example.mtgkmm.feature.search.domain.usecase.ObserveRecentlyViewedCards
import com.example.mtgkmm.feature.search.domain.usecase.SaveCard
import org.koin.dsl.module

val searchModule = module {
    single { get<MtgKmmDatabase>().localMtgCardQueries }

    factory<CardApi> { CardApiImpl(client = get()) }

    factory<CardStorage> { CardStorageImpl(localMtgCardQueries = get()) }

    factory<CardRepository> { CardRepositoryImpl(cardApi = get(), cardStorage = get()) }

    factory { GetCards(cardRepository = get()) }

    factory { SaveCard(cardRepository = get()) }

    factory { ObserveRecentlyViewedCards(cardRepository = get()) }
}
