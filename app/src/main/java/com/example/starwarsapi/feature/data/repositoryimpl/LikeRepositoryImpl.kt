package com.example.starwarsapi.feature.data.repositoryimpl

import com.example.starwarsapi.core.extantions.toEntity
import com.example.starwarsapi.feature.data.database.FavoritePeopleDao
import com.example.starwarsapi.feature.domain.model.FavoritePeople
import com.example.starwarsapi.feature.domain.repository.database.LikeDbRepository

abstract class LikeRepositoryImpl(private val dao: FavoritePeopleDao) : LikeDbRepository {
    override suspend fun setLike(favoritePeople: FavoritePeople) =
        dao.insert(favoritePeople.toEntity())

    override suspend fun deleteLike(favoritePeople: FavoritePeople) =
        dao.deletePeople(favoritePeople.toEntity())
}