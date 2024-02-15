package com.tzion.jetpackmovies.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.Surface
import androidx.lifecycle.lifecycleScope
import com.tzion.jetpackmovies.presentation.navigation.NavGraph
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {

        }
        setContent {
            MoviesTheme {
                Surface {
                    NavGraph()
                }
            }
        }
    }
}
