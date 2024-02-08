package com.hakancevik.movieappcleanarchcompose.presentation.movie_list

import com.hakancevik.movieappcleanarchcompose.domain.model.Movies

data class MovieState(
    val isLoading: Boolean = false,
    val movies: List<Movies> = emptyList(),
    val error: String = "",
    val search: String = "fargo"
)

