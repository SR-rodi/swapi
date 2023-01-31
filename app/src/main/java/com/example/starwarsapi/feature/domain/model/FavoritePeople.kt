package com.example.starwarsapi.feature.domain.model

import com.example.starwarsapi.feature.presentation.search.model.PeopleUi

class FavoritePeople(
    val id: Int?,
    val birthYear: String,
    val gender: String,
    val name: String,
    val url: String
) {
    fun toFavoritePeopleUi() = PeopleUi(birthYear, url, gender, name, true, id)
}