package com.example.mtgkmm.android.feature.card.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument
import com.example.mtgkmm.android.core.navigation.NavigationDestination
import com.example.mtgkmm.android.feature.card.model.UiMtgCard
import kotlinx.serialization.decodeFromString
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

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(CARD_DETAIL_PARAM) {
                type = UiMtgCardParamType()
            }
        )

    class UiMtgCardParamType : NavigationDestination.ParamType<UiMtgCard>() {
        override fun get(bundle: Bundle, key: String): UiMtgCard? {
            return bundle.getParcelable(key)
        }

        override fun parseValue(value: String): UiMtgCard {
            return serializer.decodeFromString(value)
        }

        override fun put(bundle: Bundle, key: String, value: UiMtgCard) {
            bundle.putParcelable(key, value)
        }
    }
}

