package com.amalwintechnologies.retrofitcoroutinesexample2.model.retrofit

import com.amalwintechnologies.retrofitcoroutinesexample2.model.CountryResponse
import retrofit2.Response
import retrofit2.http.GET

interface CountriesAPI {
    @GET("DevTides/countries/master/countriesV2.json")
    suspend fun getCountriesResponse(): Response<CountryResponse>
}