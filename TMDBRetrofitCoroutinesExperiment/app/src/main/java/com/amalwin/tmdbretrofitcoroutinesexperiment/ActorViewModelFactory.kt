package com.amalwin.tmdbretrofitcoroutinesexperiment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.usecase.GetActorsUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.usecase.UpdateActorsUseCase

class ActorViewModelFactory(
    private val getActorsUseCase: GetActorsUseCase,
    private val updateActorsUseCase: UpdateActorsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActorViewModel::class.java)) {
            return ActorViewModel(getActorsUseCase, updateActorsUseCase) as T
        }
        throw IllegalArgumentException("View model mismatch !")

    }
}