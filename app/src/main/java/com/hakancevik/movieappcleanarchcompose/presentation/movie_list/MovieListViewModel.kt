package com.hakancevik.movieappcleanarchcompose.presentation.movie_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hakancevik.movieappcleanarchcompose.domain.use_case.get_movies.GetMovieUseCase
import com.hakancevik.movieappcleanarchcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val getMovieUseCase: GetMovieUseCase) : ViewModel() {

    private val _state = mutableStateOf<MovieState>(MovieState())
    val state: androidx.compose.runtime.State<MovieState> = _state

    private var job: Job? = null

    init {
        getMovies(_state.value.search)
    }

    private fun getMovies(searchQuery: String) {
        job?.cancel()

        job = getMovieUseCase.executeGetMovies(searchQuery).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MovieState(movies = it.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = MovieState(error = it.message ?: "Something went wrong.")
                }

                is Resource.Loading -> {
                    _state.value = MovieState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }


    fun onEvent(event: MovieListEvent) {
        when (event) {
            is MovieListEvent.Search -> {
                getMovies(event.searchQuery)
            }
        }
    }

}