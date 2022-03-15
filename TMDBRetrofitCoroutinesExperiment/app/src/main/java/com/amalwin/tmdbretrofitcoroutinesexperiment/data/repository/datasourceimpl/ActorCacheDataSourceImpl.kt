package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.Actor
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.ActorCacheDataSource

class ActorCacheDataSourceImpl : ActorCacheDataSource {
    private var actorsList = ArrayList<Actor>()
    override suspend fun getActors(): List<Actor> = actorsList

    override suspend fun saveActors(actorsList: List<Actor>) {
        this.actorsList.clear()
        this.actorsList.addAll(actorsList)
    }
}