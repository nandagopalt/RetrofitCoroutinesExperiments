package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.Movie
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.MovieList
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var moviesList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> = moviesList

    override suspend fun saveMoviesToCache(moviesList: List<Movie>) {
        this.moviesList.clear()
        this.moviesList.addAll(moviesList)
    }
}


