package com.hakancevik.movieappcleanarchcompose.data.remote.dto

import com.hakancevik.movieappcleanarchcompose.domain.model.Movies

data class MoviesDto(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)


fun MoviesDto.toMovieList(): List<Movies> {
    return Search.map { search -> Movies(search.Poster, search.Title, search.Year, search.imdbID) }
}