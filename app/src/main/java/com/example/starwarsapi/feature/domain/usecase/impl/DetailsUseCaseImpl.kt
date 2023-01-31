package com.example.starwarsapi.feature.domain.usecase.impl

import com.example.starwarsapi.feature.domain.model.People
import com.example.starwarsapi.feature.domain.repository.database.DetailsDbDbRepository
import com.example.starwarsapi.feature.domain.repository.database.FavoriteDbDbRepository
import com.example.starwarsapi.feature.domain.repository.network.NetworkRepository
import com.example.starwarsapi.feature.domain.usecase.DetailsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DetailsUseCaseImpl @Inject constructor(
    private val searchRepository: NetworkRepository,
    private val databaseRepository: DetailsDbDbRepository,
) : DetailsUseCase {
    override suspend fun getDetailsInfo(url: String): Flow<People> {
        val people = searchRepository.getDetailsPeopleByUrl(url)
        return databaseRepository.getPeopleByName(people.name).map { favorite ->
            people.isFavorite = favorite != null
            people.dataBaseId = favorite?.id
            people
        }
    }
}