package com.example.mtgkmm.core.di

import io.ktor.client.engine.okhttp.OkHttp
import org.koin.dsl.module

actual fun platformModule() = module {
    single { OkHttp.create() }
}