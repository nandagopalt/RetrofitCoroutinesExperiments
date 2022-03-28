package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShowList
import retrofit2.Response


interface TVShowRemoteDataSource {
    suspend fun getTVShows(): Response<TVShowList>
}