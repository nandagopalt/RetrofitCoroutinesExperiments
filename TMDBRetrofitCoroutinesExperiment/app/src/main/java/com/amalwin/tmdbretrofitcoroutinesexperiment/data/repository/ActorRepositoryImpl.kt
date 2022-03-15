package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository

import android.util.Log
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.Actor
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.ActorsList
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.ActorCacheDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.ActorLocalDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.ActorRemoteDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.repository.ActorRepository

class ActorRepositoryImpl(
    private val actorRemoteDataSource: ActorRemoteDataSource,
    private val actorLocalDataSource: ActorLocalDataSource,
    private val actorCacheDataSource: ActorCacheDataSource
) : ActorRepository {
    override suspend fun getActors(): ActorsList? {
        TODO("Not yet implemented")
    }

    override suspend fun updateActors(): ActorsList? {
        TODO("Not yet implemented")
    }

    suspend fun getActorsFromAPI(): List<Actor> {
        lateinit var actorsList: List<Actor>
        try {
            val response = actorRemoteDataSource.getActors()
            val body = response.body()
            if (body != null) {
                actorsList = body.actors
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.toString())
        }
        return actorsList
    }

    suspend fun getActorsFromDB(): List<Actor> {
        lateinit var actorsList: List<Actor>
        try {
            actorsList = actorLocalDataSource.getActorsFromDB()
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.toString())
        }
        if (actorsList.size == 0) {
            actorsList = getActorsFromAPI()
        }
        return actorsList
    }

    suspend fun getActorsFromCache(): List<Actor> {
        lateinit var actorsList: List<Actor>
        try {
            actorsList = actorCacheDataSource.getActors()
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.toString())
        }
        if (actorsList.size == 0) {
            actorsList = getActorsFromDB()
            actorCacheDataSource.saveActors(actorsList)
        }
        return actorsList
    }
}