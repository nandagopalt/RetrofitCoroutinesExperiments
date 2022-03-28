package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.tvshow

import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.tvshow.TVShowActivity
import dagger.Subcomponent

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent {
    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TVShowSubComponent
    }
}