package com.example.retrofitcoroutinesexample1

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {
    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        private val loggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        private val okHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(loggingInterceptor)
            this.connectTimeout(30, TimeUnit.SECONDS)
            this.readTimeout(20, TimeUnit.SECONDS)
            this.writeTimeout(20, TimeUnit.SECONDS)
        }.build()

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client(okHttpClient)
                .build()
        }
    }
}