package com.example.starwarsapi.feature.presentation.details.model

import com.example.starwarsapi.feature.domain.model.FavoritePeople

class DetailsPeople(
    val birthYear: String = "",
    val name: String = "",
    val gender: String = "",
    val mass: String = "",
    var isFavorite: Boolean = false,
    val id: Int? = null,
    val url: String = ""
) {
    fun toFavorite() = FavoritePeople(id, birthYear, gender, name, url)
}