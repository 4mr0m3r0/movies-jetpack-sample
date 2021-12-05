package com.tzion.jetpackmovies.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally

private const val TWEEN_MILLIS = 700
private const val OFFSET = 1000

fun enterTransition() = slideInHorizontally(
    initialOffsetX = { OFFSET },
    animationSpec = tween(TWEEN_MILLIS)
) + fadeIn(animationSpec = tween(TWEEN_MILLIS))

fun exitTransition() = slideOutHorizontally(
    targetOffsetX = { -OFFSET },
    animationSpec = tween(TWEEN_MILLIS)
) + fadeOut(animationSpec = tween(TWEEN_MILLIS))

fun popEnterTransition() = slideInHorizontally(
    initialOffsetX = { -OFFSET },
    animationSpec = tween(TWEEN_MILLIS)
) + fadeIn(animationSpec = tween(TWEEN_MILLIS))

fun popExitTransition() = slideOutHorizontally(
    targetOffsetX = { OFFSET },
    animationSpec = tween(TWEEN_MILLIS)
) + fadeOut(animationSpec = tween(TWEEN_MILLIS))
