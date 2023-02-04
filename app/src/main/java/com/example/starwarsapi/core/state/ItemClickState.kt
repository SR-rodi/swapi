package com.example.starwarsapi.core.state

import com.example.starwarsapi.feature.presentation.model.PeopleUi

enum class ItemClickState(var people: PeopleUi? = null) {
    FAVORITE, ROOT
}