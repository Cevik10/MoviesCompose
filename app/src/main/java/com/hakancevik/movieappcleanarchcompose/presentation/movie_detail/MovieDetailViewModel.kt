package com.hakancevik.movieappcleanarchcompose.presentation.movie_detail

import androidx.lifecycle.ViewModel
import com.hakancevik.movieappcleanarchcompose.domain.use_case.get_movie_detail.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val getMovieDetailsUseCase: GetMovieDetailsUseCase) : ViewModel() {



}