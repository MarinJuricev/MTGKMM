package com.example.mtgkmm.android.core.topbar

import androidx.compose.runtime.Composable

data class TopBarViewState(
    val isVisible: Boolean = false,
    val content: @Composable (() -> Unit)? = null,
)