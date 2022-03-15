package com.amalwin.tmdbretrofitcoroutinesexperiment.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShow
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShowList

@Dao
interface TVShowDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTVShows(tvShowList: List<TVShow>)

    @Query("DELETE FROM table_tvshow")
    suspend fun deleteTVShows()

    @Query("SELECT * FROM table_tvshow")
    suspend fun getTVShows(): List<TVShow>
}