package com.example.starwarsapi.feature.presentation.search.model

import com.example.starwarsapi.feature.presentation.model.PeopleUi

class PeopleBase(
    override val birthYear: String,
    override val url: String,
    override val gender: String,
    override val name: String,
    override val favorite: Boolean = false,
    override val databaseId: Int? = null,
) : PeopleUi