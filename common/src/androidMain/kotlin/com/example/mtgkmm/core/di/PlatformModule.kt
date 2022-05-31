package com.example.mtgkmm.core.di

import com.example.mtgkmm.core.db.LocalMtgCard
import com.example.mtgkmm.core.db.MtgKmmDatabase
import com.squareup.sqldelight.EnumColumnAdapter
import com.squareup.sqldelight.android.AndroidSqliteDriver
import io.ktor.client.engine.okhttp.*
import org.koin.dsl.module

actual fun platformModule() = module {
    single { OkHttp.create() }
    single {
        MtgKmmDatabase(
            AndroidSqliteDriver(MtgKmmDatabase.Schema, get(), "mtgkmm.db"),
            localMtgCardAdapter = LocalMtgCard.Adapter(
                creatureAdapter = EnumColumnAdapter()
            )
        )
    }
}