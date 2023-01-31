package com.example.starwarsapi.di.module

import com.example.starwarsapi.feature.domain.repository.database.DetailsDbDbRepository
import com.example.starwarsapi.feature.domain.repository.database.FavoriteDbDbRepository
import com.example.starwarsapi.feature.domain.repository.network.NetworkRepository
import com.example.starwarsapi.feature.domain.usecase.SearchUseCase
import com.example.starwarsapi.feature.domain.usecase.impl.DetailsUseCaseImpl
import com.example.starwarsapi.feature.domain.usecase.impl.FavoriteUseCaseImpl
import com.example.starwarsapi.feature.domain.usecase.impl.SearchUseCaseImpl
import dagger.Provides
import javax.inject.Singleton

@dagger.Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideSearchUseCase(
        networkRepository: NetworkRepository,
        databaseRepository: FavoriteDbDbRepository,
    ): SearchUseCaseImpl = SearchUseCaseImpl(networkRepository, databaseRepository)

    @Provides
    @Singleton
    fun provideDetailsUseCase(
        networkRepository: NetworkRepository,
        databaseRepository: DetailsDbDbRepository,
    ): DetailsUseCaseImpl = DetailsUseCaseImpl(networkRepository, databaseRepository)

    @Provides
    @Singleton
    fun provideFavoriteUseCase(databaseRepository: FavoriteDbDbRepository):FavoriteUseCaseImpl =
        FavoriteUseCaseImpl(databaseRepository)

}