package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository

import android.util.Log
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.Movie
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.MovieList
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.MovieCacheDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.MovieLocalDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.MovieRemoteDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.movies.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie>? {
        val newMoviesList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newMoviesList)
        movieCacheDataSource.saveMoviesToCache(newMoviesList)
        return newMoviesList
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMoviesFromAPI()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.toString())
        }
        if (movieList.isEmpty()) {
            movieList = getMoviesFromAPI()
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.toString())
        }
        if (movieList.isEmpty()) {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}