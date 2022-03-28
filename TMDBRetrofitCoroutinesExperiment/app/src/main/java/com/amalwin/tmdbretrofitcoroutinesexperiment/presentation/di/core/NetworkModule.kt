package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.core

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.api.TMDBService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule(private val baseURL: String) {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseURL)
            .build()
    }

    @Singleton
    @Provides
    fun providesTMDBService(retrofit: Retrofit): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }

}