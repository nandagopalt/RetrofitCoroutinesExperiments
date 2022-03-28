package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.core

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

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTVShowUseCase(tvShowRepository: TVShowRepository): GetTVShowsUseCase {
        return GetTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTVShowUseCase(tvShowRepository: TVShowRepository): UpdateTVShowsUseCase {
        return UpdateTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetActorUseCase(actorRepository: ActorRepository): GetActorsUseCase {
        return GetActorsUseCase(actorRepository)
    }

    @Provides
    fun provideUpdateActorUseCase(actorRepository: ActorRepository): UpdateActorsUseCase {
        return UpdateActorsUseCase(actorRepository)
    }
}