package com.hakancevik.movieappcleanarchcompose.data.remote.dto

import com.hakancevik.movieappcleanarchcompose.domain.model.MovieDetail

data class MovieDetailDto(
    val Actors: String,
    val Awards: String,
    val BoxOffice: String,
    val Country: String,
    val DVD: String,
    val Director: String,
    val Genre: String,
    val Language: String,
    val Metascore: String,
    val Plot: String,
    val Poster: String,
    val Production: String,
    val Rated: String,
    val Ratings: List<Rating>,
    val Released: String,
    val Response: String,
    val Runtime: String,
    val Title: String,
    val Type: String,
    val Website: String,
    val Writer: String,
    val Year: String,
    val imdbID: String,
    val imdbRating: String,
    val imdbVotes: String
)

fun MovieDetailDto.toMovieDetail(): MovieDetail {
    return MovieDetail(
        Actors = this.Actors ?: "",
        Awards = this.Awards ?: "",
        Country = this.Country ?: "",
        Director = this.Director ?: "",
        Genre = this.Genre ?: "",
        Language = this.Language ?: "",
        Poster = this.Poster ?: "",
        Rated = this.Rated ?: "",
        Released = this.Released ?: "",
        Title = this.Title ?: "",
        Type = this.Type ?: "",
        Year = this.Year ?: "",
        imdbRating = this.imdbRating ?: ""
    )
}