package com.example.mtgkmm.feature.search.domain.usecase

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.example.mtgkmm.feature.search.domain.repository.CardRepository

class SaveCard(private val cardRepository: CardRepository) {

    suspend operator fun invoke(mtgCard: MtgCard): Either<Failure, Unit> =
        cardRepository.saveCard(mtgCard)
}
