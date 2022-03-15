package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.Actor
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.ActorsList
import retrofit.Response

interface ActorRemoteDataSource {
    suspend fun getActors(): Response<ActorsList>
}