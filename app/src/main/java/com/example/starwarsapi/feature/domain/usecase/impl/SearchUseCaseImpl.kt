package com.example.starwarsapi.feature.domain.usecase.impl

import com.example.starwarsapi.feature.domain.model.People
import com.example.starwarsapi.feature.domain.repository.database.FavoriteDbDbRepository
import com.example.starwarsapi.feature.domain.repository.network.NetworkRepository
import com.example.starwarsapi.feature.domain.usecase.SearchUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchUseCaseImpl @Inject constructor(
    private val searchRepository: NetworkRepository,
    private val databaseRepository: FavoriteDbDbRepository,
) : SearchUseCase {
    override suspend fun getPeopleByName(name: String): Flow<List<People>> {
        val response = searchRepository.getPeopleByName(name)
        return databaseRepository.getFavoritePeople().map { favorite ->
            response.map { people ->
                people.isFavorite = if (favorite[people.name]?.name == people.name) {
                    people.dataBaseId = favorite[people.name]?.id
                    true
                } else false
                people
            }
        }
    }
}