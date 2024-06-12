package com.amalwintechnologies.retrofitcoroutinesexample2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryResponseItem(
    val alpha2Code: String,
    val alpha3Code: String,
    val altSpellings: List<String>,
    val area: Double,
    val borders: List<String>,
    val callingCodes: List<String>,
    @SerializedName("capital")
    @Expose
    val capital: String,
    val cioc: String,
    val currencies: List<Currency>,
    val demonym: String,
    val flag: String,
    @SerializedName("flagPNG")
    @Expose
    val flagPNG: String,
    val gini: Double,
    val languages: List<Language>,
    val latlng: List<Double>,
    @SerializedName("name")
    @Expose
    val name: String,
    val nativeName: String,
    val numericCode: String,
    val population: Int,
    val region: String,
    val regionalBlocs: List<RegionalBloc>,
    val subregion: String,
    val timezones: List<String>,
    val topLevelDomain: List<String>,
    val translations: Translations
)