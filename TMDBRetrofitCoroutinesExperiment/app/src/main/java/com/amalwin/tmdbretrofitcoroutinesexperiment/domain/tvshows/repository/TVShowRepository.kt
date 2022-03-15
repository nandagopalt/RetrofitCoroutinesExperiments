package com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.repository

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShow
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShowList

interface TVShowRepository {
    suspend fun getTVShows(): List<TVShow>?
    suspend fun updateTVShows(): List<TVShow>?
}