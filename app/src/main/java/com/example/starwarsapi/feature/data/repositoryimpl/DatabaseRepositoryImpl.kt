package com.example.starwarsapi.feature.data.repositoryimpl

import com.example.starwarsapi.core.extantions.toEntity
import com.example.starwarsapi.feature.data.database.FavoritePeopleDao
import com.example.starwarsapi.feature.domain.model.FavoritePeople
import com.example.starwarsapi.feature.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val dao: FavoritePeopleDao,
) : DatabaseRepository {

    override fun getFavoritePeople() = dao.getAllPeople().map { flow ->
        flow.map { (name, people) ->
            name to people.toFavoritePeople()
        }.toMap()
    }

    override suspend fun setLike(favoritePeople: FavoritePeople) =
        dao.insert(favoritePeople.toEntity())

    override suspend fun deleteLike(favoritePeople: FavoritePeople) =
        dao.deletePeople(favoritePeople.toEntity())

    override suspend fun deleteAll() = dao.deleteAll()

}