package com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.usecase

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.Actor
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.ActorsList
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.repository.ActorRepository

class GetActorsUseCase(private val actorRepository: ActorRepository) {
    suspend fun execute(): List<Actor>? = actorRepository.getActors()
}