package com.amalwintechnologies.retrofitcoroutinesexample2.model

data class RegionalBloc(
    val acronym: String,
    val name: String,
    val otherAcronyms: List<String>,
    val otherNames: List<String>
)