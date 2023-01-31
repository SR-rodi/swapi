package com.example.starwarsapi.feature.presentation.details.model

class DetailsPeople(
    val birthYear: String = "",
    val name: String = "",
    val films: List<String> = emptyList(),
    val gender: String = "",
    val mass: String = "",
    val homeWorld: String = "",
)