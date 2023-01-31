package com.example.starwarsapi.feature.domain.repository.database

import com.example.starwarsapi.feature.domain.model.FavoritePeople
import kotlinx.coroutines.flow.Flow

interface DetailsDbDbRepository : LikeDbRepository {

    fun getPeopleByName(name: String): Flow<FavoritePeople?>

    override suspend fun setLike(favoritePeople: FavoritePeople)

    override suspend fun deleteLike(favoritePeople: FavoritePeople)
}