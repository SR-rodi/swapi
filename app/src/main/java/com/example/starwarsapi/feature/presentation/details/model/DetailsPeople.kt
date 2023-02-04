package com.example.starwarsapi.feature.presentation.details.model

import com.example.starwarsapi.feature.presentation.model.PeopleUi

class DetailsPeople(
    override val birthYear: String = "",
    override val name: String = "",
    override val gender: String = "",
    val mass: String = "",
    override var favorite: Boolean = false,
    override val databaseId: Int? = null,
    override val url: String = "",
) : PeopleUi