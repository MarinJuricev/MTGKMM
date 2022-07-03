package com.example.mtgkmm.feature.search.domain.usecase

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.feature.search.domain.model.MtgCardsData
import com.example.mtgkmm.feature.search.domain.repository.CardRepository

class GetCards(private val cardRepository: CardRepository) {

    suspend operator fun invoke(cardName: String): Either<Failure, MtgCardsData> =
        cardRepository.getCards(cardName)
}
