package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        ApplicationModule::class
    ]
)
interface ApplicationComponent {

    // We will have the factory methods after creating the sub components
}