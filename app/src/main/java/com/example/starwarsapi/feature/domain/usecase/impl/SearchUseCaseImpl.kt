package com.example.starwarsapi.feature.domain.usecase.impl

import android.util.Log
import com.example.starwarsapi.feature.domain.model.People
import com.example.starwarsapi.feature.domain.repository.DatabaseRepository
import com.example.starwarsapi.feature.domain.repository.SearchRepository
import com.example.starwarsapi.feature.domain.usecase.SearchUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchUseCaseImpl @Inject constructor(
    private val searchRepository: SearchRepository,
    private val databaseRepository: DatabaseRepository,
) : SearchUseCase {
    override suspend fun getPeopleByName(name: String): Flow<List<People>> {
        val response = searchRepository.getPeopleByName(name)
        return databaseRepository.getFavoritePeople().map { favorite ->
            response.map { people ->
                Log.e("Kart","Start")
                 if (favorite[people.name]?.name == people.name) {
                     people.dataBaseId = favorite[people.name]?.id
                     people.isFavorite = true
                 }
                people
            }
        }
    }
}