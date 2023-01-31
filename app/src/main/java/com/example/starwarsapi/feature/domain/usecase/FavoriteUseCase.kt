package com.example.starwarsapi.feature.domain.usecase

import com.example.starwarsapi.feature.domain.model.FavoritePeople
import kotlinx.coroutines.flow.Flow

interface FavoriteUseCase {

    fun getFavoritePeople(): Flow<Map<String, FavoritePeople>>
}