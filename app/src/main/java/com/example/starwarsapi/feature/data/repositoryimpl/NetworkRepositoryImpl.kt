package com.example.starwarsapi.feature.data.repositoryimpl

import com.example.starwarsapi.feature.data.api.StarWarsApi
import com.example.starwarsapi.feature.domain.repository.network.NetworkRepository
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val starWarsApi: StarWarsApi,
) : NetworkRepository {

    override suspend fun getPeopleByName(name: String) =
        starWarsApi.searchPeopleForName(name).toListPeopleDto()

    override suspend fun getDetailsPeopleByUrl(url: String) =
        starWarsApi.getPeopleFromUrl(url).toPeople()
}