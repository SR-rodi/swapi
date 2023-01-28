package com.example.starwarsapi.feature.data.model

import com.example.starwarsapi.core.extantions.toListPeople

class ResponsePeopleDto(
    private val count: Int,
    private val next: String,
    private val previous: Any,
    private val results: List<PeopleDto>
) {
    fun toListPeopleDto() = results.toListPeople()
}