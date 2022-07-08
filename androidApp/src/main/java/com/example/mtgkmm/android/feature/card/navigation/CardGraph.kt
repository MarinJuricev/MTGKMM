package com.example.mtgkmm.android.feature.card.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mtgkmm.android.feature.card.detail.DetailScreen
import com.example.mtgkmm.android.feature.card.model.UiMtgCard
import com.example.mtgkmm.android.feature.card.navigation.CardDetailDestination.CARD_DETAIL_PARAM
import com.example.mtgkmm.android.feature.card.search.SearchScreen
import org.koin.androidx.compose.getViewModel

fun NavGraphBuilder.buildCardGraph() {
    navigation(startDestination = SearchDestination.route(), route = CardRootDestination.route()) {
        composable(SearchDestination.route()) { navBackStackEntry ->
            SearchScreen(viewModel = getViewModel(owner = navBackStackEntry))
        }
        composable(CardDetailDestination.route(), CardDetailDestination.arguments) { navBackStackEntry,
            ->
            val mtgCard =
                navBackStackEntry.arguments?.getParcelable<UiMtgCard>(CARD_DETAIL_PARAM)
                    ?: error("$CARD_DETAIL_PARAM was not provided")

            DetailScreen(viewModel = getViewModel(owner = navBackStackEntry), mtgCard = mtgCard)
        }
    }
}
