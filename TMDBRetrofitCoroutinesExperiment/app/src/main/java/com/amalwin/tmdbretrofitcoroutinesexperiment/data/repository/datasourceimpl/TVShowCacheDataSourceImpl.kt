package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShow
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.TVShowCacheDataSource

class TVShowCacheDataSourceImpl : TVShowCacheDataSource {
    private var tvShowList = ArrayList<TVShow>()
    override suspend fun getTVShowsFromCache(): List<TVShow> = tvShowList

    override suspend fun saveTVShowsToCache(tvShowList: List<TVShow>) {
        this.tvShowList.clear()
        this.tvShowList.addAll(tvShowList)
    }
}