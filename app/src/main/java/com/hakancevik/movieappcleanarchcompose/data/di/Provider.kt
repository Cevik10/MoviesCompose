package com.hakancevik.movieappcleanarchcompose.data.di

import com.hakancevik.movieappcleanarchcompose.data.remote.MovieAPI
import com.hakancevik.movieappcleanarchcompose.data.repository.MoviesRepositoryImpl
import com.hakancevik.movieappcleanarchcompose.domain.repository.MovieRepository
import com.hakancevik.movieappcleanarchcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Provider {


    @Singleton
    @Provides
    fun provideMovieAPI(): MovieAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    fun provideMovieRepository(impl: MoviesRepositoryImpl): MovieRepository = impl

}