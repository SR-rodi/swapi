package com.example.starwarsapi.feature.domain.usecase.impl

import com.example.starwarsapi.feature.domain.model.FavoritePeople
import com.example.starwarsapi.feature.domain.repository.database.FavoriteDbDbRepository
import com.example.starwarsapi.feature.domain.usecase.FavoriteUseCase
import javax.inject.Inject

class FavoriteUseCaseImpl @Inject constructor(
    private val databaseRepository: FavoriteDbDbRepository,
) : FavoriteUseCase {
    override suspend fun workDataBase(favoritePeople: FavoritePeople, favorite: Boolean) {
        if (favorite) databaseRepository.deleteLike(favoritePeople)
        else databaseRepository.setLike(favoritePeople)
    }

}