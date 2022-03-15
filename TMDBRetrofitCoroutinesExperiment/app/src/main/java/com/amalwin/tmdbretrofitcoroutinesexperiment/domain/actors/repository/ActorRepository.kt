package com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.repository

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.ActorsList

interface ActorRepository {
    suspend fun getActors(): ActorsList?
    suspend fun updateActors(): ActorsList?
}