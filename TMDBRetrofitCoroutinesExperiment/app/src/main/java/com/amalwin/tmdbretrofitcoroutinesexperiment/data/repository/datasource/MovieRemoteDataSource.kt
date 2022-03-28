package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.MovieList
import retrofit2.Response


interface MovieRemoteDataSource {
    suspend fun getMoviesFromAPI(): Response<MovieList>
}