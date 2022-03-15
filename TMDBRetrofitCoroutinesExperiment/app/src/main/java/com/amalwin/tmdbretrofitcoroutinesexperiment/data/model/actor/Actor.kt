package com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "table_actor")
data class Actor(
    @PrimaryKey
    @ColumnInfo("id")
    @SerializedName("id")
    val id: Int,
    @ColumnInfo("name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo("popularity")
    @SerializedName("popularity")
    val popularity: Double,
    @ColumnInfo("profile_path")
    @SerializedName("profile_path")
    val profilePath: String
)