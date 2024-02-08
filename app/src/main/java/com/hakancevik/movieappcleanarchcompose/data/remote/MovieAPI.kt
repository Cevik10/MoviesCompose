package com.hakancevik.movieappcleanarchcompose.data.remote

import com.hakancevik.movieappcleanarchcompose.data.remote.dto.MovieDetailDto
import com.hakancevik.movieappcleanarchcompose.data.remote.dto.MoviesDto
import com.hakancevik.movieappcleanarchcompose.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchQuery: String,
        @Query("key") apiKey: String = API_KEY
    ): MoviesDto


    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("key") apiKey: String = API_KEY
    ): MovieDetailDto

}