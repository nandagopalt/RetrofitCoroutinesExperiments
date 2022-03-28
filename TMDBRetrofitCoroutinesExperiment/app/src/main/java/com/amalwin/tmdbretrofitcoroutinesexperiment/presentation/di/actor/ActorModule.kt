package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.actor

import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.usecase.GetActorsUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.actors.usecase.UpdateActorsUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.actor.ActorViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ActorModule {
    @ActorScope
    @Provides
    fun provideActorViewModelFactory(
        getActorsUseCase: GetActorsUseCase,
        updateActorsUseCase: UpdateActorsUseCase
    ): ActorViewModelFactory {
        return ActorViewModelFactory(getActorsUseCase, updateActorsUseCase)
    }
}