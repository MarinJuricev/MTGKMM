package com.example.mtgkmm.android.core.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.example.mtgkmm.android.R
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun MtgAsyncImage(
    url: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    placeHolder: @Composable (() -> Unit)? = null,
    error: @Composable (() -> Unit)? = null
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current).data(url).crossfade(true).build(),
        contentDescription = contentDescription
    ) {
        when (painter.state) {
            AsyncImagePainter.State.Empty -> {
                MtgErrorScreen(
                    modifier = Modifier.wrapContentSize(),
                    shrugTextStyle = MaterialTheme.typography.h6,
                    errorMessage = stringResource(id = R.string.image_empty_error)
                )
            }
            is AsyncImagePainter.State.Loading -> {
                if (placeHolder != null) placeHolder()
                else {
                    Box(
                        modifier =
                        Modifier.fillMaxSize()
                            .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                    )
                }
            }
            is AsyncImagePainter.State.Success -> SubcomposeAsyncImageContent()
            is AsyncImagePainter.State.Error ->
                if (error != null) error()
                else {
                    MtgErrorScreen(
                        modifier = Modifier.wrapContentSize(),
                        shrugTextStyle = MaterialTheme.typography.h6,
                        errorMessage = stringResource(id = R.string.image_fetch_error)
                    )
                }
        }
    }
}
