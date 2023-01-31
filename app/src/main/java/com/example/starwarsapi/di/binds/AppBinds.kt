package com.example.starwarsapi.di.binds

import com.example.starwarsapi.feature.data.repositoryimpl.DetailsRepositoryImpl
import com.example.starwarsapi.feature.data.repositoryimpl.FavoriteDbRepositoryImpl
import com.example.starwarsapi.feature.data.repositoryimpl.NetworkRepositoryImpl
import com.example.starwarsapi.feature.domain.repository.database.DetailsDbRepository
import com.example.starwarsapi.feature.domain.repository.database.FavoriteDbRepository
import com.example.starwarsapi.feature.domain.repository.network.NetworkRepository
import com.example.starwarsapi.feature.domain.usecase.DetailsUseCase
import com.example.starwarsapi.feature.domain.usecase.FavoriteUseCase
import com.example.starwarsapi.feature.domain.usecase.LikeUseCase
import com.example.starwarsapi.feature.domain.usecase.SearchUseCase
import com.example.starwarsapi.feature.domain.usecase.impl.DetailsUseCaseImpl
import com.example.starwarsapi.feature.domain.usecase.impl.FavoriteUseCaseImpl
import com.example.starwarsapi.feature.domain.usecase.impl.LikeUseCaseImpl
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
    fun bindsDatabaseRepository(repositoryImpl: FavoriteDbRepositoryImpl): FavoriteDbRepository

    @Binds
    @Singleton
    fun bindsDetailsRepository(repositoryImpl: DetailsRepositoryImpl): DetailsDbRepository


    @Binds
    @Singleton
    fun bindsSearchUseCase(searchUseCase: SearchUseCaseImpl): SearchUseCase

    @Binds
    @Singleton
    fun bindsLikeUseCase(favoriteUseCaseImpl: LikeUseCaseImpl): LikeUseCase

    @Binds
    @Singleton
    fun bindsDetailsUseCase(detailsUseCaseImpl: DetailsUseCaseImpl): DetailsUseCase

    @Binds
    @Singleton
    fun bindsFavoriteUseCase(favoriteUseCaseImpl: FavoriteUseCaseImpl): FavoriteUseCase

}