package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasourceimpl

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.db.TVShowDAO
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShow
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.TVShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val tvShowDAO: TVShowDAO) : TVShowLocalDataSource {
    override suspend fun getTVShowsFromDB(): List<TVShow> = tvShowDAO.getTVShows()

    override suspend fun updateTVShowsToDB(tvShowList: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.updateTVShows(tvShowList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteTVShows()
        }
    }
}

