package com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.repository

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.Actor
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.ActorsList

interface ActorRepository {
    suspend fun getActors(): List<Actor>?
    suspend fun updateActors(): List<Actor>?
}