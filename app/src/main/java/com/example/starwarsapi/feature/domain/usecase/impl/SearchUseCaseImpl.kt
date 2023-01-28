package com.example.starwarsapi.feature.domain.usecase.impl

import com.example.starwarsapi.feature.domain.model.People
import com.example.starwarsapi.feature.domain.repository.DatabaseRepository
import com.example.starwarsapi.feature.domain.repository.SearchRepository
import com.example.starwarsapi.feature.domain.usecase.SearchUseCase
import javax.inject.Inject

class SearchUseCaseImpl @Inject constructor(
    private val searchRepository: SearchRepository,
    private val databaseRepository: DatabaseRepository,
) : SearchUseCase {
    override suspend fun getPeopleByName(name: String): List<People> {

        val response = searchRepository.getPeopleByName(name)
        databaseRepository.getFavoritePeople()

        return response
    }
}