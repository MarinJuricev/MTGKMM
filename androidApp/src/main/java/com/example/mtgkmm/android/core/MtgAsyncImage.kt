package com.example.mtgkmm.android.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun MtgAsyncImage(
    url: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    placeHolder: @Composable (() -> Unit)? = null,
    error: @Composable (() -> Unit)? = null,
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
    ) {
        when (painter.state) {
            AsyncImagePainter.State.Empty -> {
                //TODO Handle this case also
            }
            is AsyncImagePainter.State.Loading -> {
                if (placeHolder != null)
                    placeHolder()
                else {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .placeholder(
                                visible = true,
                                highlight = PlaceholderHighlight.shimmer(),
                            )
                    )
                }
            }
            is AsyncImagePainter.State.Success -> SubcomposeAsyncImageContent()
            is AsyncImagePainter.State.Error ->
                if (error != null)
                    error()
                else {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Red)
                    )
                }
        }
    }
}