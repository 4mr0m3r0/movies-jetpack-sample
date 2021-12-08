package com.tzion.jetpackmovies.uicomponent

import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun TopSearchTextField(
    searchText: String,
    onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    searchIconContentDescription: String? = null,
    onSearchEvent: (KeyboardActionScope.() -> Unit)? = null
) {
    TextField(
        value = searchText,
        modifier = modifier,
        onValueChange = onSearchChange,
        placeholder = if (placeholder.isNotEmpty()) {
            { Text(placeholder) }
        } else null,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = searchIconContentDescription
            )
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = onSearchEvent
        )
    )
}

@Preview("TopSearchTextField Light")
@Composable
fun PreviewTopSearchTextFieldLight() {
    MoviesTheme {
        Surface {
            TopSearchTextField(
                searchText = "",
                onSearchChange = {},
                placeholder = "${stringResource(id = R.string.type_a_name)}...",
            )
        }
    }
}

@Preview("TopSearchTextField Dark")
@Composable
fun PreviewTopSearchTextFieldDark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            TopSearchTextField(
                searchText = "",
                onSearchChange = {},
                placeholder = "${stringResource(id = R.string.type_a_name)}...",
            )
        }
    }
}