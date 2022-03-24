package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di

import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.actor.ActorActivity
import dagger.Subcomponent

@ActorScope
@Subcomponent
interface ActorSubComponent {
    fun inject(actorActivity: ActorActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActorSubComponent
    }
}