package com.example.starwarsapi.feature.data.repositoryimpl

import com.example.starwarsapi.feature.data.api.StarWarsApi
import com.example.starwarsapi.feature.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val starWarsApi: StarWarsApi
) : SearchRepository {

    override suspend fun getPeopleByName(name: String) =
        starWarsApi.searchPeopleForName(name).toListPeopleDto()
}