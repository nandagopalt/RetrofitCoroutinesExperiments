package com.amalwin.tmdbretrofitcoroutinesexperiment.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.Movie
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.MovieList

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateMovies(movieList: List<Movie>)

    @Query("DELETE FROM table_movie")
    suspend fun deleteMovies()

    @Query("SELECT * FROM table_movie")
    suspend fun getMovies(): List<Movie>
}