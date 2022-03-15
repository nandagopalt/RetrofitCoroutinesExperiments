package com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie


import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)