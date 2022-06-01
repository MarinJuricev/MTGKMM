package com.example.mtgkmm.android.core.components.topbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntSize

@Composable
fun MtgTopBar(state: TopBarViewState) {
    val topBarSpring: FiniteAnimationSpec<IntSize> = spring(
        dampingRatio = Spring.DampingRatioLowBouncy,
        stiffness = Spring.StiffnessVeryLow,
    )

    AnimatedVisibility(
        visible = state.isVisible,
        enter = expandVertically(
            animationSpec = topBarSpring
        ),
        exit = shrinkVertically(
            animationSpec = topBarSpring
        ),
    ) {
        state.content?.let { content -> content() }
    }
}