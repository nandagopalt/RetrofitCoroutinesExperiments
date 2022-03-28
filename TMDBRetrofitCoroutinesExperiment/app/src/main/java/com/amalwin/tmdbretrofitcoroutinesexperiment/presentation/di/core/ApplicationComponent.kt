package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.core

import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.actor.ActorSubComponent
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.movie.MovieSubComponent
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.tvshow.TVShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
    ]
)
interface ApplicationComponent {
    // We will have the factory methods after creating the sub components
    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TVShowSubComponent.Factory
    fun actorSubComponent(): ActorSubComponent.Factory
}