package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.core

import android.content.Context
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.actor.ActorSubComponent
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.movie.MovieSubComponent
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.tvshow.TVShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TVShowSubComponent::class, ActorSubComponent::class])
class ApplicationModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}