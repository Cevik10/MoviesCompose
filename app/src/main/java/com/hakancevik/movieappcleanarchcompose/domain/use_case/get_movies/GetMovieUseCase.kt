package com.hakancevik.movieappcleanarchcompose.domain.use_case.get_movies

import com.hakancevik.movieappcleanarchcompose.data.remote.dto.MoviesDto
import com.hakancevik.movieappcleanarchcompose.data.remote.dto.toMovieList
import com.hakancevik.movieappcleanarchcompose.domain.model.Movies
import com.hakancevik.movieappcleanarchcompose.domain.repository.MovieRepository
import com.hakancevik.movieappcleanarchcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovies(search: String): Flow<Resource<List<Movies>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)

            if (movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error(message = "No Movie Found"))
            }

        } catch (e: IOError) {
            emit(Resource.Error(message = "No Internet Connection"))

        } catch (e: HttpException) {
            emit(Resource.Error(message = "No Internet Connection"))
        }
    }

}