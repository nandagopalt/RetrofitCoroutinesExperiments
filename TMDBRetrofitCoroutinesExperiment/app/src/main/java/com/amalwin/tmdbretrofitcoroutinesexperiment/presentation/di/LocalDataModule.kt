package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.db.ActorDAO
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.db.MovieDAO
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.db.TVShowDAO
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.ActorLocalDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.MovieLocalDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.MovieRemoteDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.TVShowLocalDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl.ActorLocalDataSourceImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl.MovieLocalDataSourceImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl.MovieRemoteDataSourceImpl
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl.TVShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDAO)
    }

    @Singleton
    @Provides
    fun provideTVShowLocalDataSource(tvShowDAO: TVShowDAO): TVShowLocalDataSource {
        return TVShowLocalDataSourceImpl(tvShowDAO)
    }

    @Singleton
    @Provides
    fun provideActorLocalDataSource(actorDAO: ActorDAO): ActorLocalDataSource {
        return ActorLocalDataSourceImpl(actorDAO)
    }


}