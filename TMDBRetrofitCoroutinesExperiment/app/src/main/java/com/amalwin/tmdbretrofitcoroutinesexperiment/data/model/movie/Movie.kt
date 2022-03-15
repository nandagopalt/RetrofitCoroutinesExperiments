package com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "table_movie")
data class Movie(
    @PrimaryKey
    @ColumnInfo("id")
    @SerializedName("id")
    val id: Int,
    @ColumnInfo("overview")
    @SerializedName("overview")
    val overview: String,
    @ColumnInfo("popularity")
    @SerializedName("popularity")
    val popularity: Double,
    @ColumnInfo("poster_path")
    @SerializedName("poster_path")
    val posterPath: String,
    @ColumnInfo("release_data")
    @SerializedName("release_date")
    val releaseDate: String,
    @ColumnInfo("title")
    @SerializedName("title")
    val title: String,
    @ColumnInfo("vote_average")
    @SerializedName("vote_average")
    val voteAverage: Double,
    @ColumnInfo("vote_count")
    @SerializedName("vote_count")
    val voteCount: Int
)