package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.Movie
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.MovieList

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(moviesList: List<Movie>)
    suspend fun clearAll()
}