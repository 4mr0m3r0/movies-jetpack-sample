package com.tzion.jetpackmovies.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.domain.posters.command.SearchPostersCommand
import com.tzion.jetpackmovies.presentation.search.SearchUserIntent.Search
import com.tzion.jetpackmovies.presentation.search.SearchUserIntent.SelectPosterAsFavorite
import com.tzion.jetpackmovies.presentation.search.SearchUserIntent.TapOnPoster
import com.tzion.jetpackmovies.presentation.search.intenthandler.FindIntentHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindMoviesViewModel @Inject constructor(val intentHandler: FindIntentHandler) : ViewModel() {
    var posters: Flow<PagingData<Movie.Poster>> = emptyFlow()
        private set
    private val _screenState = MutableStateFlow(FindUserInterface.defaultUi())
    val screenState: StateFlow<FindUserInterface> = _screenState
    val _sideEffect = MutableSharedFlow<FindSideEffect>()
    val sideEffect = _sideEffect
        .shareIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000)
        )
    private var job: Job? = null
    val sendUserIntent: (userIntent: FindUserIntent) -> Unit = { processUserIntent(userIntent = it) }
    val userIntent = MutableSharedFlow<SearchUserIntent>()

//    val screenState = stateMachine.screenState
//        .buffer(DEFAULT_CAPACITY)
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5_000),
//            initialValue = stateMachine.defaultScreenState
//        )
//    val sideEffect = stateMachine.sideEffect.shareIn(
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(5_000)
//    )
//    val state: StateFlow<FindUserInterface>
//    val pagingDataFlow: Flow<PagingData<Movie.Poster>>
//    val accept: (FindUserIntent) -> Unit

    init {
//        stateMachine.coroutineScope = viewModelScope

//        val initialQuery: String = savedStateHandle[LAST_SEARCH_QUERY] ?: ""
//        val lastQueryScrolled: String = savedStateHandle[LAST_QUERY_SCROLLED] ?: ""
//        val actionStateFlow = MutableSharedFlow<FindUserIntent>()
//        val searches = actionStateFlow
//            .filterIsInstance<SearchMovieIntent>()
//            .distinctUntilChanged()
//            .onStart {
//                val intent = SearchMovieIntent().also { it.query = initialQuery }
//                emit(intent)
//            }
//        val queriesScrolled = actionStateFlow
//            .filterIsInstance<ScrollIntent>()
//            .distinctUntilChanged()
//            .shareIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
//                replay = 1
//            )
//            .onStart {
//                val intent = ScrollIntent().also { it.query = lastQueryScrolled }
//                emit(intent)
//            }
//        pagingDataFlow = searches
//            .flatMapLatest { searchMovies(query = it.query) }
//            .cachedIn(viewModelScope)
        //        state = combine(searches, queriesScrolled, ::Pair)
//            .map { (search, scroll) ->
//                FindUserInterface(
//                    query = search.query.orEmpty(),
//                    lastQueryScrolled = scroll.query.orEmpty(),
//                    hasNotScrolledForCurrentSearch = search.query != scroll.query
//                )
//            }.stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
//                initialValue = FindUserInterface.default()
//            )
//        accept = { action ->
//            viewModelScope.launch { actionStateFlow.emit(action) }
//        }
    }

    private fun processUserIntent(userIntent: FindUserIntent, coroutineScope: CoroutineScope = viewModelScope) {
        job?.cancel()
        job = coroutineScope.launch {

            try {
                userIntent.execute()
                if (userIntent is SearchMovieIntent) {
                    posters = userIntent.pagingPosters
                }
            } catch (e: Exception) {
                _screenState.update { FindUserInterface(errorMessage = e.localizedMessage) }
            }
        }
    }

    private fun identifyUserIntents(userIntent: SearchUserIntent) {
        when (userIntent) {
            is Search -> SearchPostersCommand().also { it.execute() }
            SelectPosterAsFavorite -> TODO("Domain command")
            is TapOnPoster -> TODO("Navigate")
        }
    }

    override fun onCleared() {
//        savedStateHandle[LAST_SEARCH_QUERY] = state.value.query
//        savedStateHandle[LAST_QUERY_SCROLLED] = state.value.lastQueryScrolled
        super.onCleared()
    }

    companion object {
        private const val DEFAULT_CAPACITY = 3
        private const val LAST_SEARCH_QUERY = "last_search_query"
        private const val LAST_QUERY_SCROLLED = "last_query_scrolled"
    }
}
