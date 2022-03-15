package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShow
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShowList

interface TVShowCacheDataSource {
    suspend fun getTVShowsFromCache(): List<TVShow>
    suspend fun saveTVShowsToCache(tvShowList: List<TVShow>)
}