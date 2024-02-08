package com.hakancevik.movieappcleanarchcompose.data.repository

import com.hakancevik.movieappcleanarchcompose.data.remote.MovieAPI
import com.hakancevik.movieappcleanarchcompose.data.remote.dto.MovieDetailDto
import com.hakancevik.movieappcleanarchcompose.data.remote.dto.MoviesDto
import com.hakancevik.movieappcleanarchcompose.domain.repository.MovieRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val movieAPI: MovieAPI) : MovieRepository {
    override suspend fun getMovies(searchQuery: String): MoviesDto {
        return movieAPI.getMovies(searchQuery = searchQuery)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return movieAPI.getMovieDetail(imdbId = imdbId)
    }
}