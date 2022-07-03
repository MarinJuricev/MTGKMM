package com.example.mtgkmm.android.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mtgkmm.android.R

@Composable
fun MtgErrorScreen(
    errorMessage: String,
    modifier: Modifier = Modifier,
    shrugTextStyle: TextStyle = MaterialTheme.typography.h2
) {
    Card(
        modifier =
        modifier
            .fillMaxSize()
            .wrapContentSize()
            .padding(horizontal = dimensionResource(id = R.dimen.margin_big)),
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.margin_big))
        ) {
            Text(
                text = stringResource(id = R.string.shrug_emoji),
                style = shrugTextStyle,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.margin_medium)))
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
    }
}
