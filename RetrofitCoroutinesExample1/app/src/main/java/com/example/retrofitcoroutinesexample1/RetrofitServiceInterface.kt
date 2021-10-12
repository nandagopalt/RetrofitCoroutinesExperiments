package com.example.retrofitcoroutinesexample1

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServiceInterface {

    @GET("/albums")
    suspend fun getAllAlbums(): Response<Albums>

    @GET("/albums")
    suspend fun getAlbumsForId(@Query("id") id: Int): Response<Albums>

    @GET("albums/{id}")
    suspend fun getAlbums(@Path("id") albumId: Int): Response<AlbumsItem>
}