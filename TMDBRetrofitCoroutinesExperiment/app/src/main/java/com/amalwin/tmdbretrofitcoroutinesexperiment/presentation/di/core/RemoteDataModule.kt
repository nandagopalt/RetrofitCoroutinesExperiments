package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.core

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.api.TMDBService
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.ActorRemoteDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.MovieRemoteDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.TVShowRemoteDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl.ActorRemoteDataSourceImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl.MovieRemoteDataSourceImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl.TVShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTVShowDataSource(tmdbService: TMDBService): TVShowRemoteDataSource {
        return TVShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideActorDataSource(tmdbService: TMDBService): ActorRemoteDataSource {
        return ActorRemoteDataSourceImpl(tmdbService, apiKey)
    }

}