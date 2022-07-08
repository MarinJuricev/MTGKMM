package com.example.mtgkmm.core.di

import com.example.mtgkmm.feature.search.data.model.local.LocalMtgStat
import com.example.mtgkmm.feature.search.domain.model.MtgKeyword
import com.squareup.sqldelight.ColumnAdapter
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun commonModule(enableNetworkLogs: Boolean) = module {
    single {
        Json {
            isLenient = true
            ignoreUnknownKeys = true
            explicitNulls = false
        }
    }

    single(named(BASE_URL)) { "https://api.scryfall.com/" }

    single {
        createHttpClient(
            httpClientEngine = get(),
            json = get(),
            enableNetworkLogs = enableNetworkLogs,
            baseUrl = get(named(BASE_URL)),
        )
    }

    single<ColumnAdapter<List<MtgKeyword>, String>>(named(MTG_KEYWORD_ADAPTER_NAME)) {
        val serializer: Json = get()

        object : ColumnAdapter<List<MtgKeyword>, String> {
            override fun decode(databaseValue: String) =
                if (databaseValue.isEmpty()) {
                    listOf()
                } else {
                    serializer.decodeFromString<List<MtgKeyword>>(databaseValue)
                }

            override fun encode(value: List<MtgKeyword>) = serializer.encodeToString(value)
        }
    }

    single<ColumnAdapter<LocalMtgStat, String>>(named(MTG_STAT_ADAPTER_NAME)) {
        val serializer: Json = get()

        object : ColumnAdapter<LocalMtgStat, String> {
            override fun decode(databaseValue: String) =
                serializer.decodeFromString<LocalMtgStat>(databaseValue)

            override fun encode(value: LocalMtgStat) = serializer.encodeToString(value)
        }
    }
}

fun createHttpClient(
    httpClientEngine: HttpClientEngine,
    json: Json,
    enableNetworkLogs: Boolean,
    baseUrl: String,
) =
    HttpClient(httpClientEngine) {
        install(ContentNegotiation) { json(json) }
        if (enableNetworkLogs) {
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
        }
        defaultRequest { url(baseUrl) }
    }

private const val BASE_URL = "baseUrl"
const val MTG_KEYWORD_ADAPTER_NAME = "mtgKeywordAdapterName"
const val MTG_STAT_ADAPTER_NAME = "mtgStatAdapterName"
