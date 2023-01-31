package com.example.starwarsapi.feature.data.repositoryimpl

import com.example.starwarsapi.feature.data.database.FavoritePeopleDao
import com.example.starwarsapi.feature.domain.repository.database.FavoriteDbDbRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteDbRepositoryImpl @Inject constructor(
    private val dao: FavoritePeopleDao,
) : FavoriteDbDbRepository, LikeRepositoryImpl(dao) {

    override fun getFavoritePeople() = dao.getAllPeople().map { flow ->
        flow.map { (name, people) ->
            name to people.toFavoritePeople()
        }.toMap()
    }
}