package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.movies.usecase.GetMoviesUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.movies.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {
    init {
t
    }

    fun getMovies() = liveData {
        val moviesList = getMoviesUseCase.execute()
        emit(moviesList)
    }

    fun updateMovies() = liveData {
        val moviesList = updateMoviesUseCase.execute()
        emit(moviesList)
    }
}