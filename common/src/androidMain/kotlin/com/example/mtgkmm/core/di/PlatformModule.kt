package com.example.mtgkmm.core.di

import com.example.mtgkmm.core.db.LocalMtgCard
import com.example.mtgkmm.core.db.MtgKmmDatabase
import com.russhwolf.settings.AndroidSettings
import com.squareup.sqldelight.EnumColumnAdapter
import com.squareup.sqldelight.android.AndroidSqliteDriver
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.qualifier.named
import org.koin.dsl.module

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
    single { AndroidSettings.Factory(get()).create() }
}
