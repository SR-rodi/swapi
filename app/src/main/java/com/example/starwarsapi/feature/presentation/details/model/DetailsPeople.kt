package com.example.starwarsapi.feature.presentation.details.model

import com.example.starwarsapi.feature.domain.model.FavoritePeople

class DetailsPeople(
    val birthYear: String = "",
    val name: String = "",
    val films: List<String> = emptyList(),
    val gender: String = "",
    val mass: String = "",
    val homeWorld: String = "",
    var isFavorite: Boolean = false,
    val id: Int? = null
) {
    fun toFavorite() = FavoritePeople(id, birthYear, gender, name)
}