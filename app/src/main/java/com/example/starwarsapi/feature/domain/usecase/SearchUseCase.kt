package com.example.starwarsapi.feature.domain.usecase

import com.example.starwarsapi.feature.domain.model.People

interface SearchUseCase {

    suspend fun getPeopleByName(name: String):List<People>
}