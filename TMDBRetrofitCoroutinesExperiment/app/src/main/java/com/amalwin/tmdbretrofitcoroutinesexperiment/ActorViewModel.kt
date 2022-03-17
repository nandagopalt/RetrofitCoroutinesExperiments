package com.amalwin.tmdbretrofitcoroutinesexperiment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.usecase.GetActorsUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.usecase.UpdateActorsUseCase

class ActorViewModel(
    private val getActorsUseCase: GetActorsUseCase,
    private val updateActorsUseCase: UpdateActorsUseCase
) : ViewModel() {
    init {

    }

    fun getActors() = liveData {
        val actorsList = getActorsUseCase.execute()
        emit(actorsList)
    }

    fun updateActors() = liveData {
        val actorsList = updateActorsUseCase.execute()
        emit(actorsList)
    }

}