package com.amalwin.tmdbretrofitcoroutinesexperiment.data.api

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.ActorsList
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.MovieList
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShowList
import retrofit.Response
import retrofit.http.GET
import retrofit.http.Query

interface TMDBService {
    @GET("/movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("/tv/popular")
    suspend fun getPopularTVShows(@Query("api_key") apiKey: String): Response<TVShowList>

    @GET("/person/popular")
    suspend fun getPopularActors(@Query("api_key") apiKey: String): Response<ActorsList>
}