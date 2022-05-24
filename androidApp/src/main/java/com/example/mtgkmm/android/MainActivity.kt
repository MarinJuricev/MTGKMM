package com.example.mtgkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mtgkmm.android.core.navigation.MtgNavigation
import com.example.mtgkmm.android.core.navigation.Navigator
import com.example.mtgkmm.android.core.theme.MtgTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val navigator: Navigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MtgTheme {
                MtgNavigation(
                    navigator = navigator,
                )
            }
        }
    }
}
