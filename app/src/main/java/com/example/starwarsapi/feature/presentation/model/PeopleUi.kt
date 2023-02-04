package com.example.starwarsapi.feature.presentation.model

import com.example.starwarsapi.feature.domain.model.FavoritePeople

interface PeopleUi {

    val birthYear: String
    val url: String
    val gender: String
    val name: String
    val favorite: Boolean
    val databaseId: Int?

    fun toFavoritePeople() = FavoritePeople(databaseId, birthYear, gender, name, url)
}