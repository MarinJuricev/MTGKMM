package com.example.mtgkmm.android.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette =
    darkColors(primary = purpleDark, primaryVariant = purple, secondary = purpleLight)

private val LightColorPalette =
    lightColors(
        primary = purpleDark,
        primaryVariant = purple,
        secondary = purpleLight,
        background = white,
    )

@Composable
fun MtgTheme(isDarkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}
