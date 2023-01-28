package com.example.starwarsapi.di

import com.example.starwarsapi.feature.data.repositoryimpl.SearchRepositoryImpl
import com.example.starwarsapi.feature.domain.repository.SearchRepository
import dagger.Binds

@dagger.Module
interface AppBinds {

    @Binds
    fun bindsSearchRepository(repositoryImpl: SearchRepositoryImpl): SearchRepository
}