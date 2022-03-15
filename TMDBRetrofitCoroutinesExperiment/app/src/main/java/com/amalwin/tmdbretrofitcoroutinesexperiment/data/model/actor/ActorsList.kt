package com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor


import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.Actor
import com.google.gson.annotations.SerializedName

data class ActorsList(
    @SerializedName("results")
    val actors: List<Actor>
)