package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di

import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.usecase.GetTVShowsUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.usecase.UpdateTVShowsUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.tvshow.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {
    @TVShowScope
    @Provides
    fun provideTVShowViewModelFactory(
        getTVShowsUseCase: GetTVShowsUseCase,
        updateTVShowsUseCase: UpdateTVShowsUseCase
    ): TVShowViewModelFactory {
        return TVShowViewModelFactory(getTVShowsUseCase, updateTVShowsUseCase)
    }
}