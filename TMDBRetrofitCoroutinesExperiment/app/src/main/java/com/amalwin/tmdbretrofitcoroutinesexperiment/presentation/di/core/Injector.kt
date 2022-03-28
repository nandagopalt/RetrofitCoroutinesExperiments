package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.core

import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.actor.ActorSubComponent
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.movie.MovieSubComponent
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.tvshow.TVShowSubComponent

interface Injector {
    fun createMovieSubcomponent(): MovieSubComponent
    fun createTVShowSubComponent(): TVShowSubComponent
    fun createActorSubComponent(): ActorSubComponent
}