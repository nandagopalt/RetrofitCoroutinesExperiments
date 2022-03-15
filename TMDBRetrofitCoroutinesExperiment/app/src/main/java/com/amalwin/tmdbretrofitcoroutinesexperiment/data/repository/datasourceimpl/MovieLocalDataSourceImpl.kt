package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.db.MovieDAO
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.Movie
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.MovieList
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDAO: MovieDAO) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> = movieDAO.getMovies()

    override suspend fun saveMoviesToDB(moviesList: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.updateMovies(moviesList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteMovies()
        }
    }
}