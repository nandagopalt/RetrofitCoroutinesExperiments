package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.api.TMDBService
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.MovieList
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.MovieRemoteDataSource
import retrofit.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDataSource {
    override suspend fun getMoviesFromAPI(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)
}