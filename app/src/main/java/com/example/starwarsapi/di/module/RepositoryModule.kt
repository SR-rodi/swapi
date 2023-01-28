package com.example.starwarsapi.di.module

import com.example.starwarsapi.feature.data.api.StarWarsApi
import com.example.starwarsapi.feature.data.database.FavoritePeopleDao
import com.example.starwarsapi.feature.data.repositoryimpl.DatabaseRepositoryImpl
import com.example.starwarsapi.feature.data.repositoryimpl.SearchRepositoryImpl
import dagger.Provides

@dagger.Module
class RepositoryModule {

    @Provides
    fun provideSearchRepository(searApi: StarWarsApi) = SearchRepositoryImpl(searApi)

    @Provides
    fun provideDataBaseRepository(dao: FavoritePeopleDao) = DatabaseRepositoryImpl(dao)

}