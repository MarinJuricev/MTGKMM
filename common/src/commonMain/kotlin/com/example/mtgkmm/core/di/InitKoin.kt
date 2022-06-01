@file:OptIn(ExperimentalSerializationApi::class)

package com.example.mtgkmm.core.di

import com.example.mtgkmm.feature.search.di.searchModule
import com.example.mtgkmm.feature.search.domain.model.MtgKeyword
import com.squareup.sqldelight.ColumnAdapter
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
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

    single<ColumnAdapter<List<MtgKeyword>, String>> {
        val serializer: Json = get()

        object : ColumnAdapter<List<MtgKeyword>, String> {
            override fun decode(databaseValue: String) =
                if (databaseValue.isEmpty()) {
                    listOf()
                } else {
                    serializer.decodeFromString<List<MtgKeyword>>(databaseValue)
                }

            override fun encode(value: List<MtgKeyword>) =
                serializer.encodeToString(value)
        }
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