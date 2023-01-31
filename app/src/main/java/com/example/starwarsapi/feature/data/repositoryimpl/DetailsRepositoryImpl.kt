package com.example.starwarsapi.feature.data.repositoryimpl

import com.example.starwarsapi.feature.data.database.FavoritePeopleDao
import com.example.starwarsapi.feature.domain.repository.database.DetailsDbRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val dao: FavoritePeopleDao,
) : LikeRepositoryImpl(dao), DetailsDbRepository {

    override fun getPeopleByName(name: String) =
        dao.getPeopleByName(name).map { entity -> entity?.toFavoritePeople() }
}