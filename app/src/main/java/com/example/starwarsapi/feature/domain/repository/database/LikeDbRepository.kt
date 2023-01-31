package com.example.starwarsapi.feature.domain.repository.database

import com.example.starwarsapi.feature.domain.model.FavoritePeople

interface LikeDbRepository {

    suspend fun setLike(favoritePeople: FavoritePeople)

    suspend fun deleteLike(favoritePeople: FavoritePeople)
}
