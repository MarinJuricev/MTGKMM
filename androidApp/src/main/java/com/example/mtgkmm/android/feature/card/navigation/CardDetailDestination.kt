package com.example.mtgkmm.android.feature.card.navigation

import android.net.Uri
import com.example.mtgkmm.android.core.navigation.NavigationDestination
import com.example.mtgkmm.android.feature.card.model.UiMtgCard
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object CardDetailDestination : NavigationDestination<UiMtgCard>, KoinComponent {

    private val serializer: Json by inject()

    const val CARD_DETAIL_PARAM = "card"

    private const val CARD_DETAIL_ROOT = "cardDetail"
    private const val CARD_DETAIL_ROUTE = "$CARD_DETAIL_ROOT/{$CARD_DETAIL_PARAM}"

    override fun route(): String = CARD_DETAIL_ROUTE

    override fun buildRoute(data: UiMtgCard): String =
        "$CARD_DETAIL_ROOT/${Uri.encode(serializer.encodeToString(data))}"

}


