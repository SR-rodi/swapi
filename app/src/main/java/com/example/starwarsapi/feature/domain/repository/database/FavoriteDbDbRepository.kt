package com.example.starwarsapi.feature.domain.repository.database

import com.example.starwarsapi.feature.domain.model.FavoritePeople
import kotlinx.coroutines.flow.Flow

interface FavoriteDbDbRepository: LikeDbRepository {

    fun getFavoritePeople(): Flow<Map<String, FavoritePeople>>

    override suspend fun setLike(favoritePeople: FavoritePeople)

    override suspend fun deleteLike(favoritePeople: FavoritePeople)

}