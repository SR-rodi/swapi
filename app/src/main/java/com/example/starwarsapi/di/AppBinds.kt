package com.example.starwarsapi.di

import com.example.starwarsapi.feature.data.repositoryimpl.DatabaseRepositoryImpl
import com.example.starwarsapi.feature.data.repositoryimpl.SearchRepositoryImpl
import com.example.starwarsapi.feature.domain.repository.DatabaseRepository
import com.example.starwarsapi.feature.domain.repository.SearchRepository
import com.example.starwarsapi.feature.domain.usecase.SearchUseCase
import com.example.starwarsapi.feature.domain.usecase.impl.SearchUseCaseImpl
import dagger.Binds

@dagger.Module
interface AppBinds {

    @Binds
    fun bindsSearchRepository(repositoryImpl: SearchRepositoryImpl): SearchRepository

    @Binds
    fun bindsDatabaseRepository(repositoryImpl: DatabaseRepositoryImpl): DatabaseRepository

    @Binds
    fun bindsSearchUseCase(searchUseCase: SearchUseCaseImpl): SearchUseCase
}