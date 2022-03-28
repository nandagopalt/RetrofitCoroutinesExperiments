package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.core

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.ActorRepositoryImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.MovieRepositoryImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.TVShowRepositoryImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.*
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.repository.ActorRepository
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.movies.repository.MovieRepository
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.repository.TVShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTVShowRepository(
        tvShowRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource
    ): TVShowRepository {
        return TVShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideActorRepository(
        actorRemoteDataSource: ActorRemoteDataSource,
        actorLocalDataSource: ActorLocalDataSource,
        actorCacheDataSource: ActorCacheDataSource
    ): ActorRepository {
        return ActorRepositoryImpl(
            actorRemoteDataSource,
            actorLocalDataSource,
            actorCacheDataSource
        )
    }


}