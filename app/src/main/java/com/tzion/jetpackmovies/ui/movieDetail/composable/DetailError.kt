package com.tzion.jetpackmovies.ui.movieDetail.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.tzion.jetpackmovies.R

@Composable
fun DetailError() {
    Snackbar(
        modifier = Modifier.padding(dimensionResource(R.dimen.snackbar_padding))
    ) {
        Text(text = stringResource(R.string.something_went_wrong))
    }
}
