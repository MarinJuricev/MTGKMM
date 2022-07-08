package com.example.mtgkmm.feature.search.data.local

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.buildRight
import com.example.mtgkmm.core.db.LocalMtgCard
import com.example.mtgkmm.core.db.LocalMtgCardQueries
import com.example.mtgkmm.feature.search.data.model.local.toLocal
import com.example.mtgkmm.feature.search.domain.model.MtgCard
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow

class CardStorageImpl(val localMtgCardQueries: LocalMtgCardQueries) : CardStorage {

    override suspend fun saveCard(card: MtgCard): Either<Failure, Unit> {
        return with(card) {
            localMtgCardQueries
                .insertItem(
                    name,
                    manaCost,
                    creature,
                    url,
                    keywords,
                    stat.toLocal(),
                    oracleText,
                    legalities.toString(),
                    artist,
                )
                .buildRight()
        }
    }

    override fun observeRecentlyViewedCards(): Flow<List<LocalMtgCard>> =
        localMtgCardQueries.selectAll().asFlow().mapToList()
}
