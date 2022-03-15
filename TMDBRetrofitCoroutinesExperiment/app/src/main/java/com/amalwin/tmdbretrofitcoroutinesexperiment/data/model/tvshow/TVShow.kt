package com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "table_tvshow")
data class TVShow(
    @PrimaryKey
    @ColumnInfo("id")
    @SerializedName("id")
    val id: Int,
    @ColumnInfo("name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo("original_name")
    @SerializedName("original_name")
    val originalName: String,
    @ColumnInfo("overview")
    @SerializedName("overview")
    val overview: String,
    @ColumnInfo("poster_path")
    @SerializedName("poster_path")
    val posterPath: String,
    @ColumnInfo("vote_average")
    @SerializedName("vote_average")
    val voteAverage: Double,
    @ColumnInfo("vote_count")
    @SerializedName("vote_count")
    val voteCount: Int
)