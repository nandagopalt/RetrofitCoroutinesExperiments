package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.Actor

interface ActorCacheDataSource {
    suspend fun getActors(): List<Actor>
    suspend fun saveActors(actorsList: List<Actor>)
}