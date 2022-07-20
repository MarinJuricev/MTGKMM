package com.example.mtgkmm.core.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.example.mtgkmm.core.db.LocalMtgCard
import com.example.mtgkmm.core.db.MtgKmmDatabase
import com.russhwolf.settings.datastore.DataStoreSettings
import com.squareup.sqldelight.EnumColumnAdapter
import com.squareup.sqldelight.android.AndroidSqliteDriver
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.qualifier.named
import org.koin.dsl.module

val Context.dataStore: DataStore<> by preferenceDataStore(name = "settings")

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
    single {
        val context: Context



        DataStoreSettings(context.dataStore) }
}

