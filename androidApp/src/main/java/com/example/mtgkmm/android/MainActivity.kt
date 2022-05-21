package com.example.mtgkmm.android

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import com.example.mtgkmm.Greeting
import com.example.mtgkmm.android.search.SearchScreen
import com.example.mtgkmm.android.search.viewmodel.SearchViewModel
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
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
