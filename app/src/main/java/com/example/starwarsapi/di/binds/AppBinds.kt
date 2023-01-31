package com.example.starwarsapi.di.binds

import com.example.starwarsapi.feature.data.repositoryimpl.DetailsRepositoryImpl
import com.example.starwarsapi.feature.data.repositoryimpl.FavoriteDbRepositoryImpl
import com.example.starwarsapi.feature.data.repositoryimpl.NetworkRepositoryImpl
import com.example.starwarsapi.feature.domain.repository.database.DetailsDbDbRepository
import com.example.starwarsapi.feature.domain.repository.database.FavoriteDbDbRepository
import com.example.starwarsapi.feature.domain.repository.network.NetworkRepository
import com.example.starwarsapi.feature.domain.usecase.DetailsUseCase
import com.example.starwarsapi.feature.domain.usecase.FavoriteUseCase
import com.example.starwarsapi.feature.domain.usecase.SearchUseCase
import com.example.starwarsapi.feature.domain.usecase.impl.DetailsUseCaseImpl
import com.example.starwarsapi.feature.domain.usecase.impl.FavoriteUseCaseImpl
import com.example.starwarsapi.feature.domain.usecase.impl.SearchUseCaseImpl
import dagger.Binds
import javax.inject.Singleton

@dagger.Module
interface AppBinds {

    @Binds
    @Singleton
    fun bindsSearchRepository(repositoryImpl: NetworkRepositoryImpl): NetworkRepository

    @Binds
    @Singleton
    fun bindsDatabaseRepository(repositoryImpl: FavoriteDbRepositoryImpl): FavoriteDbDbRepository

    @Binds
    @Singleton
    fun bindsDetailsRepository(repositoryImpl: DetailsRepositoryImpl): DetailsDbDbRepository


    @Binds
    @Singleton
    fun bindsSearchUseCase(searchUseCase: SearchUseCaseImpl): SearchUseCase

    @Binds
    @Singleton
    fun bindsFavoriteUseCase(favoriteUseCaseImpl: FavoriteUseCaseImpl): FavoriteUseCase

    @Binds
    @Singleton
    fun bindsDetailsUseCase(detailsUseCaseImpl: DetailsUseCaseImpl): DetailsUseCase


}