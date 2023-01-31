package com.example.starwarsapi.di.module

import com.example.starwarsapi.feature.data.api.StarWarsApi
import com.example.starwarsapi.feature.data.database.FavoritePeopleDao
import com.example.starwarsapi.feature.data.repositoryimpl.DetailsRepositoryImpl
import com.example.starwarsapi.feature.data.repositoryimpl.FavoriteDbRepositoryImpl
import com.example.starwarsapi.feature.data.repositoryimpl.NetworkRepositoryImpl
import dagger.Provides
import javax.inject.Singleton

@dagger.Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNetworkRepository(searApi: StarWarsApi) = NetworkRepositoryImpl(searApi)

    @Provides
    @Singleton
    fun provideFavoriteRepository(dao: FavoritePeopleDao) = FavoriteDbRepositoryImpl(dao)


    @Provides
    @Singleton
    fun provideDetailsRepository(dao: FavoritePeopleDao) = DetailsRepositoryImpl(dao)

}