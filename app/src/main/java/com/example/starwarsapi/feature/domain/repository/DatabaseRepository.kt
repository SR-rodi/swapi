package com.example.starwarsapi.feature.domain.repository

import com.example.starwarsapi.feature.domain.model.FavoritePeople
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    fun getFavoritePeople(): Flow<Map<String, FavoritePeople>>

    suspend fun setLike(favoritePeople: FavoritePeople)

    suspend fun deleteLike(favoritePeople: FavoritePeople)

    suspend fun deleteAll()

}