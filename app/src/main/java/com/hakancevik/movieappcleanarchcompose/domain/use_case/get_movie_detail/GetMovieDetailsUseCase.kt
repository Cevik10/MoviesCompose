package com.hakancevik.movieappcleanarchcompose.domain.use_case.get_movie_detail

import com.hakancevik.movieappcleanarchcompose.data.remote.dto.toMovieDetail
import com.hakancevik.movieappcleanarchcompose.domain.model.MovieDetail
import com.hakancevik.movieappcleanarchcompose.domain.repository.MovieRepository
import com.hakancevik.movieappcleanarchcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetails(imdbId: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId = imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No Internet Connection"))

        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Something went wrong."))
        }
    }


}