package com.example.starwarsapi.feature.domain.usecase.impl

import android.util.Log
import com.example.starwarsapi.feature.domain.model.FavoritePeople
import com.example.starwarsapi.feature.domain.repository.DatabaseRepository
import com.example.starwarsapi.feature.domain.usecase.FavoriteUseCase
import javax.inject.Inject

class FavoriteUseCaseImpl @Inject constructor(
    private val databaseRepository: DatabaseRepository,
) : FavoriteUseCase {
    override suspend fun workDataBase(favoritePeople: FavoritePeople, favorite: Boolean) {
        if (favorite) {
            Log.e("Kart","delete")
            databaseRepository.deleteLike(favoritePeople)
        }
        else {
            Log.e("Kart","set")
            databaseRepository.setLike(favoritePeople)
        }
    }

}