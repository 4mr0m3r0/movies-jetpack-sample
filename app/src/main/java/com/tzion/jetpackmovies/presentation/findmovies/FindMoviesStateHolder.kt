package com.tzion.jetpackmovies.presentation.findmovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzion.jetpackmovies.presentation.findmovies.FindUserInterface.NavigateToDetail
import com.tzion.jetpackmovies.presentation.findmovies.FindUserInterface.ScreenState
import com.tzion.jetpackmovies.presentation.findmovies.state.FindStateMachine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindMoviesStateHolder @Inject constructor(
    private val stateMachine: FindStateMachine
) : ViewModel() {

    private val screenState: MutableStateFlow<ScreenState> = MutableStateFlow(ScreenState())
    private var job: Job? = null

    fun screenState(): StateFlow<ScreenState> = screenState

    init {
        stateMachine.userInterface = { checkAndUpdateScreenState(action = it) }
    }

    private fun checkAndUpdateScreenState(action: FindUserInterface) {
        when (action) {
            is ScreenState -> screenState.update { action }
            NavigateToDetail -> TODO("Navigation not yet implemented")
        }
    }

    fun processUserIntent(userIntent: FindUserIntent) {
        job?.cancel()
        job = viewModelScope.launch {
            try {
                userIntent.execute(stateMachine)
            } catch (e: Exception) {
                stateMachine.searchFailed()
            }
        }
    }
}
