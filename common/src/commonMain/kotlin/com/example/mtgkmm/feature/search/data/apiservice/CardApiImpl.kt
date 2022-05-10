package com.example.mtgkmm.feature.search.data.apiservice

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.data.apiCall
import com.example.mtgkmm.feature.search.data.model.NetworkCardsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments

class CardApiImpl(
    private val client: HttpClient,
) : CardApi {

    override suspend fun getCard(
        cardName: String
    ): Either<Failure, NetworkCardsResponse> {
        return client.apiCall { httpClient ->
            httpClient.get {
                url.appendPathSegments("test")
            }.body()
        }
    }
}