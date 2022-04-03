package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation

import android.app.Application
import com.amalwin.tmdbretrofitcoroutinesexperiment.BuildConfig
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.actor.ActorSubComponent
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.core.*
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.movie.MovieSubComponent
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.tvshow.TVShowSubComponent

class App: Application(), Injector {
    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubcomponent(): MovieSubComponent {
       return appComponent.movieSubComponent().create()
    }

    override fun createTVShowSubComponent(): TVShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createActorSubComponent(): ActorSubComponent {
        return appComponent.actorSubComponent().create()
    }
}