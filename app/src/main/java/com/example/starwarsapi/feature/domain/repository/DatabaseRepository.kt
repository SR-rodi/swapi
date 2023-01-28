package com.example.starwarsapi.feature.domain.repository

import com.example.starwarsapi.feature.domain.model.FavoritePeople

interface DatabaseRepository {
    suspend fun getFavoritePeople(): List<FavoritePeople>
}