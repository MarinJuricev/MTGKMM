@file:OptIn(ExperimentalSerializationApi::class)

package com.example.mtgkmm.core.di

import com.example.mtgkmm.feature.search.di.searchModule
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(
    enableNetworkLogs: Boolean = false,
    appDeclaration: KoinAppDeclaration = {}
) = startKoin {
    appDeclaration()
    modules(
        platformModule(),
        commonModule(enableNetworkLogs),
        searchModule
    )
}

// Called by non Android consumers
fun initKoin() = initKoin(enableNetworkLogs = false) {}

fun commonModule(enableNetworkLogs: Boolean) = module {
    single {
        Json {
            isLenient = true
            ignoreUnknownKeys = true
            explicitNulls = false
        }
    }

    single(named(BASE_URL)) {
        "https://api.scryfall.com/"
    }

    single {
        createHttpClient(
            httpClientEngine = get(),
            json = get(),
            enableNetworkLogs = enableNetworkLogs,
            baseUrl = get(named(BASE_URL))
        )
    }

}

fun createHttpClient(
    httpClientEngine: HttpClientEngine,
    json: Json,
    enableNetworkLogs: Boolean,
    baseUrl: String,
) = HttpClient(httpClientEngine) {
    install(ContentNegotiation) {
        json(json)
    }
    if (enableNetworkLogs) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
    }
    defaultRequest {
        url(baseUrl)
        //client.get<…> { url.appendPath("graphql") } // appended to "https://example.com/foo/"
        //client.get<…> { url("https://otherdomain.com/foo") } // completely overwrites URL
    }
}

private const val BASE_URL = "baseUrl"