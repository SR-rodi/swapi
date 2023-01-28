package com.example.starwarsapi.feature.domain.model

import com.google.gson.annotations.SerializedName

class People(
    val birthYear: String,
    val eyeColor: String,
    val hairColor: String,
    val homeWorld: String,
    val skin_color: String,
    val species: List<String>,
    val starships: List<String>,
    val url: String,
    val vehicles: List<String>,
    val created: String,
    val edited: String,
    val films: List<String>,
    val gender: String,
    val mass: String,
    val name: String,
    val height: String,
)