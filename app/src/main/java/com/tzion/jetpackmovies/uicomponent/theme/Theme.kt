package com.tzion.jetpackmovies.uicomponent.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightThemeColors = lightColorScheme(
    primary = PrimaryColor,
    primaryContainer = PrimaryDarkColor,
    secondary = SecondaryColor
)

private val DarkThemeColors = darkColorScheme(
    primary = PrimaryLightColor,
    primaryContainer = PrimaryDarkColor,
    secondary = SecondaryLightColor
)

@Composable
fun MoviesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {

    MaterialTheme(
        colorScheme = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = Typography,
        shapes = shapes,
        content = content
    )
}