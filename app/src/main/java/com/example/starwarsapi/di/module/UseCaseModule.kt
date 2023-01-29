package com.example.starwarsapi.di.module

import com.example.starwarsapi.feature.domain.repository.DatabaseRepository
import com.example.starwarsapi.feature.domain.repository.SearchRepository
import com.example.starwarsapi.feature.domain.usecase.impl.FavoriteUseCaseImpl
import com.example.starwarsapi.feature.domain.usecase.impl.SearchUseCaseImpl
import dagger.Provides
import javax.inject.Singleton

@dagger.Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideSearchUseCase(
        searchRepository: SearchRepository,
        databaseRepository: DatabaseRepository,
    ) = SearchUseCaseImpl(searchRepository, databaseRepository)

    @Provides
    @Singleton
    fun provideFavoriteUseCase(databaseRepository: DatabaseRepository) =
        FavoriteUseCaseImpl(databaseRepository)

}