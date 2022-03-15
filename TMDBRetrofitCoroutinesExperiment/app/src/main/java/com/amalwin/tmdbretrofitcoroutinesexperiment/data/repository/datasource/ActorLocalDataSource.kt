package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.Actor

interface ActorLocalDataSource {
    suspend fun getActorsFromDB(): List<Actor>
    suspend fun saveActorsToDB(actorsList: List<Actor>)
    suspend fun clearAll()
}