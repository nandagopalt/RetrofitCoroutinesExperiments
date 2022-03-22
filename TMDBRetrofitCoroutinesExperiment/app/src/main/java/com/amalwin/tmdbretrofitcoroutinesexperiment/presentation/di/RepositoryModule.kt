package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.ActorRepositoryImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.MovieRepositoryImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.TVShowRepositoryImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.*
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.repository.ActorRepository
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.repository.TVShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepositoryImpl {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
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

    @Singleton
    @Provides
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