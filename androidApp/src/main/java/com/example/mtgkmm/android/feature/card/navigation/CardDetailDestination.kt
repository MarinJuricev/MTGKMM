package com.example.mtgkmm.android.feature.card.navigation

import androidx.navigation.NamedNavArgument
import com.example.mtgkmm.android.core.navigation.NavigationDestination

object CardDetailDestination : NavigationDestination {

    const val CARD_DETAIL_ID_PARAM = "id"

    private const val CARD_DETAIL_ROOT = "cardDetail"
    private const val CARD_DETAIL_ROUTE = "$CARD_DETAIL_ROOT/{$CARD_DETAIL_ID_PARAM}"

    override fun route(): String = CARD_DETAIL_ROUTE

    override val arguments: List<NamedNavArgument>
        get() = super.arguments
}


