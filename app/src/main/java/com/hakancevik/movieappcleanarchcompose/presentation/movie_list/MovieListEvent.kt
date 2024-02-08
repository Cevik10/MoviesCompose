package com.hakancevik.movieappcleanarchcompose.presentation.movie_list

sealed class MovieListEvent {
    data class Search(val searchQuery: String) : MovieListEvent()
}