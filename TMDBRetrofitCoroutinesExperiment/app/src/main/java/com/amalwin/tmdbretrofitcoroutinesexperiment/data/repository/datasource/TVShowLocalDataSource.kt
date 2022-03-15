package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShow

interface TVShowLocalDataSource {
    suspend fun getTVShowsFromDB(): List<TVShow>
    suspend fun updateTVShowsToDB(tvShowList: List<TVShow>)
    suspend fun clearAll()
}