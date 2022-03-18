package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit.GsonConverterFactory
import retrofit.Retrofit
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

    @Provides
    fun providesTMDBService(retrofit: Retrofit): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }

}