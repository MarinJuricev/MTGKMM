package com.example.mtgkmm.core.di

import com.example.mtgkmm.core.db.LocalMtgCard
import com.example.mtgkmm.core.db.MtgKmmDatabase
import com.russhwolf.settings.AppleSettings
import com.russhwolf.settings.NSUserDefaultsSettings
import com.squareup.sqldelight.EnumColumnAdapter
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual fun platformModule() = module {
    single { Darwin.create() }
    single {
        MtgKmmDatabase(
            NativeSqliteDriver(MtgKmmDatabase.Schema, "mtgkmm.db"),
            localMtgCardAdapter =
            LocalMtgCard.Adapter(
                creatureAdapter = EnumColumnAdapter(),
                keywordsAdapter = get(named(MTG_KEYWORD_ADAPTER_NAME)),
                statAdapter = get(named(MTG_STAT_ADAPTER_NAME)),
            ),
        )
    }
    single { NSUserDefaultsSettings.Factory().create() }
}
