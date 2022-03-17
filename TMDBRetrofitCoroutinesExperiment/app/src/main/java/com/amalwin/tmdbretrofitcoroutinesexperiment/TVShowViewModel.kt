package com.amalwin.tmdbretrofitcoroutinesexperiment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.usecase.GetTVShowsUseCase
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.usecase.UpdateTVShowsUseCase

class TVShowViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModel() {
    init {

    }

    fun getTVShows() = liveData {
        val tvShowList = getTVShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTVShows() = liveData {
        val tvShowList = updateTVShowsUseCase.execute()
        emit(tvShowList)
    }
}