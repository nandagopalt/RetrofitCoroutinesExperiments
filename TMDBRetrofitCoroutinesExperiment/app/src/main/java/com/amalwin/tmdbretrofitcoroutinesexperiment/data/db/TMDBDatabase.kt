package com.amalwin.tmdbretrofitcoroutinesexperiment.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.Actor
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.Movie
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShow

@Database(entities = [Movie::class, TVShow::class, Actor::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun getMovieDAO(): MovieDAO
    abstract fun getTVShowDAO(): TVShowDAO
    abstract fun getActorDAO(): ActorDAO
}