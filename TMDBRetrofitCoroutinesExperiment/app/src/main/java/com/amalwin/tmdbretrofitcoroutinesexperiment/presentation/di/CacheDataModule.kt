package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.ActorCacheDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.MovieCacheDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.TVShowCacheDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl.ActorCacheDataSourceImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl.MovieCacheDataSourceImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl.TVShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVShowDataSource(): TVShowCacheDataSource {
        return TVShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideActorDataSource(): ActorCacheDataSource {
        return ActorCacheDataSourceImpl()
    }
}