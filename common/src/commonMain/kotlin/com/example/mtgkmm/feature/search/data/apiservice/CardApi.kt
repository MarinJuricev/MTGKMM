package com.example.mtgkmm.feature.search.data.apiservice

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.feature.search.data.model.NetworkCardsResponse

interface CardApi {
    suspend fun getCard(cardName: String): Either<Failure, NetworkCardsResponse>
}