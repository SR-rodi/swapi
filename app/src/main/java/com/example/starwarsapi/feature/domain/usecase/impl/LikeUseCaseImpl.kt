package com.example.starwarsapi.feature.domain.usecase.impl

import com.example.starwarsapi.feature.domain.model.FavoritePeople
import com.example.starwarsapi.feature.domain.repository.database.FavoriteDbRepository
import com.example.starwarsapi.feature.domain.usecase.LikeUseCase
import javax.inject.Inject

class LikeUseCaseImpl @Inject constructor(
    private val databaseRepository: FavoriteDbRepository,
) : LikeUseCase {

    override suspend fun workDataBase(favoritePeople: FavoritePeople, favorite: Boolean) {
        if (favorite) databaseRepository.deleteLike(favoritePeople)
        else databaseRepository.setLike(favoritePeople)
    }
}