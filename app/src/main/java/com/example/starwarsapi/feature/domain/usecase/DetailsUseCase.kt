package com.example.starwarsapi.feature.domain.usecase

import com.example.starwarsapi.feature.domain.model.People
import kotlinx.coroutines.flow.Flow

interface DetailsUseCase {

    suspend fun getDetailsInfo(url: String): Flow<People>
}