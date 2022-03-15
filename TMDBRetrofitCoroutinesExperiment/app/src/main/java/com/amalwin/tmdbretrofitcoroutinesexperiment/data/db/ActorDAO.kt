package com.amalwin.tmdbretrofitcoroutinesexperiment.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.Actor
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.ActorsList

@Dao
interface ActorDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateActors(actorsList: List<Actor>)

    @Query("DELETE FROM table_actor")
    suspend fun deleteActors()

    @Query("SELECT * FROM table_actor")
    suspend fun getActors(): List<Actor>
}