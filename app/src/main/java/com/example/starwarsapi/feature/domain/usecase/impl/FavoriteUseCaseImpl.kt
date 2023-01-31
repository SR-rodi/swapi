package com.example.starwarsapi.feature.domain.usecase.impl

import com.example.starwarsapi.feature.domain.repository.database.FavoriteDbRepository
import com.example.starwarsapi.feature.domain.usecase.FavoriteUseCase
import javax.inject.Inject

class FavoriteUseCaseImpl @Inject constructor(
    private val favoriteDbRepository: FavoriteDbRepository
) : FavoriteUseCase {

    override fun getFavoritePeople() = favoriteDbRepository.getFavoritePeople()
}