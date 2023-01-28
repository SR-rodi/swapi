package com.example.starwarsapi.feature.data.repositoryimpl

import com.example.starwarsapi.core.extantions.toListFavorite
import com.example.starwarsapi.feature.data.database.FavoritePeopleDao
import com.example.starwarsapi.feature.domain.model.FavoritePeople
import com.example.starwarsapi.feature.domain.repository.DatabaseRepository
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val dao: FavoritePeopleDao
) : DatabaseRepository {

    override suspend fun getFavoritePeople() = dao.getAllPeople().toListFavorite()
}