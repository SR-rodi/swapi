package com.example.starwarsapi.core.state

import com.example.starwarsapi.feature.presentation.search.model.PeopleUi

enum class ItemClickState(var people: PeopleUi? = null) {
    FAVORITE, ROOT
}