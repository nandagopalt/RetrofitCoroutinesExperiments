package com.amalwintechnologies.retrofitcoroutinesexample2.model.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountriesService {

    companion object {
        private val BASE_URL = "https://raw.githubusercontent.com/"

        fun getCountriesService(): CountriesAPI {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(CountriesAPI::class.java)
        }
    }

}