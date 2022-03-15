package com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow


import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShow
import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val TVShows: List<TVShow>
)