package com.hakancevik.movieappcleanarchcompose.domain.repository

import com.hakancevik.movieappcleanarchcompose.data.remote.dto.MovieDetailDto
import com.hakancevik.movieappcleanarchcompose.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(searchQuery: String): MoviesDto
    suspend fun getMovieDetail(imdbId: String): MovieDetailDto


}