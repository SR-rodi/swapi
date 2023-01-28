package com.example.starwarsapi.di

import com.example.starwarsapi.feature.data.api.StarWarsApi
import com.example.starwarsapi.feature.data.repositoryimpl.SearchRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module(includes = [AppBinds::class])
class Module {

    @Provides
    fun providerRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideApi(retrofit: Retrofit) = retrofit.create<StarWarsApi>()

    @Provides
    fun provideSearchRepository(searApi: StarWarsApi) = SearchRepositoryImpl(searApi)

    companion object {
        private const val BASE_URL = "https://swapi.dev/api/"
    }
}