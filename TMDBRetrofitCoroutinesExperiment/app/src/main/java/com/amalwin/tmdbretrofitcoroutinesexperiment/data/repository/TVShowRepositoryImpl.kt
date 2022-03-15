package com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository

import android.util.Log
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShow
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShowList
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.TVShowCacheDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.TVShowLocalDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.repository.datasource.TVShowRemoteDataSource
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.repository.TVShowRepository

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tVShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource
) : TVShowRepository {
    override suspend fun getTVShows(): List<TVShow>? = getTVShowsFromCache()

    override suspend fun updateTVShows(): List<TVShow>? {
        val newTVShowList = getTVShowsFromAPI()
        tVShowLocalDataSource.clearAll()
        tVShowLocalDataSource.updateTVShowsToDB(newTVShowList)
        tvShowCacheDataSource.saveTVShowsToCache(newTVShowList)
        return newTVShowList
    }

    suspend fun getTVShowsFromAPI(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            val response = tvShowRemoteDataSource.getTVShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.TVShows
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.toString())
        }
        return tvShowList
    }

    suspend fun getTVShowsFromDB(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tVShowLocalDataSource.getTVShowsFromDB()
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.toString())
        }
        if (tvShowList.size == 0) {
            tvShowList = getTVShowsFromAPI()
        }
        return tvShowList
    }

    suspend fun getTVShowsFromCache(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowCacheDataSource.getTVShowsFromCache()
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.toString())
        }
        if (tvShowList.size == 0) {
            tvShowList = getTVShowsFromDB()
            tvShowCacheDataSource.saveTVShowsToCache(tvShowList)
        }
        return tvShowList
    }
}