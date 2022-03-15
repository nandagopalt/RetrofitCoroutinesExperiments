package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.db.ActorDAO
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.Actor
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.ActorLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActorLocalDataSourceImpl(private val actorDAO: ActorDAO) : ActorLocalDataSource {
    override suspend fun getActorsFromDB(): List<Actor> = actorDAO.getActors()

    override suspend fun saveActorsToDB(actorsList: List<Actor>) {
        CoroutineScope(Dispatchers.IO).launch {
            actorDAO.updateActors(actorsList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            actorDAO.deleteActors()
        }
    }
}