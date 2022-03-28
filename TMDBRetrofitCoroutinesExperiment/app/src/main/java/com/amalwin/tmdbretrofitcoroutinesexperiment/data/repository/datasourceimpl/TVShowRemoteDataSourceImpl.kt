package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.api.TMDBService
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShowList
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.TVShowRemoteDataSource
import retrofit2.Response


class TVShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    TVShowRemoteDataSource {
    override suspend fun getTVShows(): Response<TVShowList> =
        tmdbService.getPopularTVShows(apiKey)
}