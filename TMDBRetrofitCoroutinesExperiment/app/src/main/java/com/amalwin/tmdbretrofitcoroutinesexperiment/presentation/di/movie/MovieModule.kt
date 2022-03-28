package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.movie

import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.movies.usecase.GetMoviesUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.movies.usecase.UpdateMoviesUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}