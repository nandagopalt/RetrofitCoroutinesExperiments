package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.usecase.GetTVShowsUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.usecase.UpdateTVShowsUseCase

class TVShowViewModelFactory(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TVShowViewModel::class.java)) {
            return TVShowViewModel(getTVShowsUseCase, updateTVShowsUseCase) as T
        }
        throw IllegalArgumentException("View model mismatch !")
    }
}