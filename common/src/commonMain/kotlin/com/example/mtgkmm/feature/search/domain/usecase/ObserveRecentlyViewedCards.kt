package com.example.mtgkmm.feature.search.domain.usecase

import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.example.mtgkmm.feature.search.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow

class ObserveRecentlyViewedCards(
    private val cardRepository: CardRepository,
) {

    operator fun invoke(): Flow<List<MtgCard>> =
        cardRepository.observeRecentlyViewedCards()
}