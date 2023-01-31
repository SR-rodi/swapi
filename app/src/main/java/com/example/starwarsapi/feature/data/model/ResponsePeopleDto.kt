package com.example.starwarsapi.feature.data.model

import com.example.starwarsapi.core.extantions.toListPeople

class ResponsePeopleDto(
    private val results: List<PeopleDto>
) {
    fun toListPeopleDto() = results.toListPeople()
}