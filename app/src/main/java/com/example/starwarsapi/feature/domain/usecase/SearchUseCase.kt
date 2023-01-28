package com.example.starwarsapi.feature.domain.usecase

import com.example.starwarsapi.feature.domain.model.People
import kotlinx.coroutines.flow.Flow

interface SearchUseCase {

    suspend fun getPeopleByName(name: String): Flow<List<People>>
}