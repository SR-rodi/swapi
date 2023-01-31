package com.example.starwarsapi.feature.data.repositoryimpl

import com.example.starwarsapi.feature.data.database.FavoritePeopleDao
import com.example.starwarsapi.feature.domain.repository.database.DetailsDbDbRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val dao: FavoritePeopleDao,
) : LikeRepositoryImpl(dao), DetailsDbDbRepository {

    override fun getPeopleByName(name: String) =
        dao.getPeopleByName(name).map { entity -> entity?.toFavoritePeople() }
}