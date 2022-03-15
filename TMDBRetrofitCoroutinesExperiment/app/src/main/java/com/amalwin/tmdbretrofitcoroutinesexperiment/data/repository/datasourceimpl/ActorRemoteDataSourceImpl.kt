package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.api.TMDBService
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.ActorsList
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.ActorRemoteDataSource
import retrofit.Response

class ActorRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    ActorRemoteDataSource {
    override suspend fun getActors(): Response<ActorsList> = tmdbService.getPopularActors(apiKey)
}