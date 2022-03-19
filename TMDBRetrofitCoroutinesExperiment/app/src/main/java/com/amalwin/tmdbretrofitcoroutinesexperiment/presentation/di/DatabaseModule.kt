package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di

import android.content.Context
import androidx.room.Room
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.db.ActorDAO
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.db.MovieDAO
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.db.TMDBDatabase
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.db.TVShowDAO
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides
    fun provideDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "TMDBDatabase").build()
    }

    @Provides
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase): MovieDAO {
        return tmdbDatabase.getMovieDAO()
    }

    @Provides
    fun provideTVShowDAO(tmdbDatabase: TMDBDatabase): TVShowDAO {
        return tmdbDatabase.getTVShowDAO()
    }

    fun provideActorDAO(tmdbDatabase: TMDBDatabase): ActorDAO {
        return tmdbDatabase.getActorDAO()
    }


}