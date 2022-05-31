package com.example.mtgkmm.core.di

import com.example.mtgkmm.core.db.MtgKmmDatabase
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import io.ktor.client.engine.darwin.*
import org.koin.dsl.module

actual fun platformModule() = module {
    single { Darwin.create() }
    single {
        MtgKmmDatabase(
            NativeSqliteDriver(MtgKmmDatabase.Schema, "mtgkmm.db"),
        )
    }
}