package com.example.starwarsapi.feature.domain.usecase

import com.example.starwarsapi.feature.domain.model.FavoritePeople

interface FavoriteUseCase {

    suspend fun workDataBase(favoritePeople: FavoritePeople, favorite: Boolean)
}