package com.tzion.jetpackmovies.presentation.findmovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzion.jetpackmovies.presentation.findmovies.FindUserInterface.NavigateToDetail
import com.tzion.jetpackmovies.presentation.findmovies.FindUserInterface.ScreenState
import com.tzion.jetpackmovies.presentation.findmovies.intenthandler.FindIntentHandler
import com.tzion.jetpackmovies.presentation.findmovies.state.FindStateMachine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindMoviesViewModel @Inject constructor(
    private val stateMachine: FindStateMachine,
    val intentHandler: FindIntentHandler,
) : ViewModel() {
    private var job: Job? = null
    val sendUserIntent: (userIntent: FindUserIntent) -> Unit = { processUserIntent(userIntent = it) }
    val screenState = stateMachine.screenState
        .buffer(DEFAULT_CAPACITY)
        .handleNavigation()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = stateMachine.defaultScreenState
        )

    init {
        stateMachine.coroutineScope = viewModelScope //TODO: fix this issue. Two different spots for setting the scope.
    }

    private fun processUserIntent(userIntent: FindUserIntent, coroutineScope: CoroutineScope = viewModelScope) {
        job?.cancel()
        job = coroutineScope.launch {
            try {
                userIntent.execute(stateMachine)
            } catch (e: Exception) {
                stateMachine.searchFailed(error = e.localizedMessage)
            }
        }
    }

    private fun Flow<FindUserInterface>.handleNavigation(): Flow<ScreenState> = flow {
        collect { userInterface ->
            if (userInterface is NavigateToDetail) {
                println(">>> Navigate to Detail")
            } else {
                emit(userInterface as ScreenState)
            }
        }
    }

    companion object {
        private const val DEFAULT_CAPACITY = 3
    }
}
