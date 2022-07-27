package com.example.mtgkmm.core.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.mtgkmm.core.db.LocalMtgCard
import com.example.mtgkmm.core.db.MtgKmmDatabase
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.coroutines.FlowSettings
import com.russhwolf.settings.datastore.DataStoreSettings
import com.squareup.sqldelight.EnumColumnAdapter
import com.squareup.sqldelight.android.AndroidSqliteDriver
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.qualifier.named
import org.koin.dsl.module

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@OptIn(ExperimentalSettingsImplementation::class, ExperimentalSettingsApi::class)
actual fun platformModule() = module {
    single { OkHttp.create() }
    single {
        MtgKmmDatabase(
            AndroidSqliteDriver(MtgKmmDatabase.Schema, get(), "mtgkmm.db"),
            localMtgCardAdapter =
            LocalMtgCard.Adapter(
                creatureAdapter = EnumColumnAdapter(),
                keywordsAdapter = get(named(MTG_KEYWORD_ADAPTER_NAME)),
                statAdapter = get(named(MTG_STAT_ADAPTER_NAME)),
            ),
        )
    }
    single<FlowSettings> {
        DataStoreSettings(get<Context>().dataStore)
    }
}

