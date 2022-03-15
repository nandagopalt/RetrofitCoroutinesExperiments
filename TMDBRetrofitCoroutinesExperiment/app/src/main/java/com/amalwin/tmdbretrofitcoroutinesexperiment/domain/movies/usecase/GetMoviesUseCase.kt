package com.amalwin.tmdbretrofitcoroutinesexperiment.domain.movies.usecase

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.ActorsList
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.Movie
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.MovieList
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.movies.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}