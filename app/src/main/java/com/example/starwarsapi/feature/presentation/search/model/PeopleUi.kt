package com.example.starwarsapi.feature.presentation.search.model

import com.example.starwarsapi.feature.domain.model.FavoritePeople

class PeopleUi(
    val birthYear: String,
    val url: String,
    val gender: String,
    val name: String,
    val favorite: Boolean = false,
    val databaseId: Int? = null,
) {
    fun toFavoritePeople() = FavoritePeople(databaseId, birthYear, gender, name)
}