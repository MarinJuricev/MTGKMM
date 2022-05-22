package com.example.mtgkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.mtgkmm.android.core.navigation.Navigator
import com.example.mtgkmm.android.search.SearchScreen
import com.example.mtgkmm.android.search.viewmodel.SearchViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {

    private val navigator: Navigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: SearchViewModel = getViewModel()
            val state by viewModel.state.collectAsState()

            SearchScreen(
                state,
                viewModel::onEvent
            )
        }
    }
}
