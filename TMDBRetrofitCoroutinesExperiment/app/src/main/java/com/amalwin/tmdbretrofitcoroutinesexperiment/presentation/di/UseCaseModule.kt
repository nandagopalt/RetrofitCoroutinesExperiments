package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di

import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.repository.ActorRepository
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.usecase.GetActorsUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.usecase.UpdateActorsUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.movies.repository.MovieRepository
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.movies.usecase.GetMoviesUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.movies.usecase.UpdateMoviesUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.repository.TVShowRepository
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.usecase.GetTVShowsUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.usecase.UpdateTVShowsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetTVShowUseCase(tvShowRepository: TVShowRepository): GetTVShowsUseCase {
        return GetTVShowsUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateTVShowUseCase(tvShowRepository: TVShowRepository): UpdateTVShowsUseCase {
        return UpdateTVShowsUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideGetActorUseCase(actorRepository: ActorRepository): GetActorsUseCase {
        return GetActorsUseCase(actorRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateActorUseCase(actorRepository: ActorRepository): UpdateActorsUseCase {
        return UpdateActorsUseCase(actorRepository)
    }
}