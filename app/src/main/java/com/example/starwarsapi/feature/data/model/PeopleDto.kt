package com.example.starwarsapi.feature.data.model

import com.example.starwarsapi.feature.domain.model.People
import com.google.gson.annotations.SerializedName

class PeopleDto(
    @SerializedName("birth_year") private val birthYear: String,
    @SerializedName("eye_color") private val eyeColor: String,
    @SerializedName("hair_color") private val hairColor: String,
    @SerializedName("homeworld") private val homeWorld: String,
    @SerializedName("skin_color") private val skinColor: String,
    private val species: List<String>,
    private val starships: List<String>,
    private val url: String,
    private val vehicles: List<String>,
    private val created: String,
    private val edited: String,
    private val films: List<String>,
    private val gender: String,
    private val mass: String,
    private val name: String,
    private val height: String,
) {
    fun toPeople() = People(
        birthYear,
        eyeColor,
        hairColor,
        homeWorld,
        skinColor,
        species,
        starships,
        url,
        vehicles,
        created,
        edited,
        films,
        gender,
        mass,
        name,
        height
    )
}