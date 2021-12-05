package com.tzion.jetpackmovies.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Surface
import com.tzion.jetpackmovies.ui.navigation.NavGraph
import com.tzion.jetpackmovies.ui.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                Surface {
                    NavGraph()
                }
            }
        }
    }
}
