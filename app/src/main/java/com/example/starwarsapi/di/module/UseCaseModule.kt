package com.example.starwarsapi.di.module

import com.example.starwarsapi.feature.domain.repository.database.DetailsDbRepository
import com.example.starwarsapi.feature.domain.repository.database.FavoriteDbRepository
import com.example.starwarsapi.feature.domain.repository.network.NetworkRepository
import com.example.starwarsapi.feature.domain.usecase.impl.DetailsUseCaseImpl
import com.example.starwarsapi.feature.domain.usecase.impl.FavoriteUseCaseImpl
import com.example.starwarsapi.feature.domain.usecase.impl.LikeUseCaseImpl
import com.example.starwarsapi.feature.domain.usecase.impl.SearchUseCaseImpl
import dagger.Provides
import javax.inject.Singleton

@dagger.Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideSearchUseCase(
        networkRepository: NetworkRepository,
        databaseRepository: FavoriteDbRepository,
    ): SearchUseCaseImpl = SearchUseCaseImpl(networkRepository, databaseRepository)

    @Provides
    @Singleton
    fun provideDetailsUseCase(
        networkRepository: NetworkRepository,
        databaseRepository: DetailsDbRepository,
    ): DetailsUseCaseImpl = DetailsUseCaseImpl(networkRepository, databaseRepository)

    @Provides
    @Singleton
    fun provideLikeUseCase(databaseRepository: FavoriteDbRepository):LikeUseCaseImpl =
        LikeUseCaseImpl(databaseRepository)

    @Provides
    @Singleton
    fun provideFavoriteUseCase(databaseRepository: FavoriteDbRepository):FavoriteUseCaseImpl =
        FavoriteUseCaseImpl(databaseRepository)
}