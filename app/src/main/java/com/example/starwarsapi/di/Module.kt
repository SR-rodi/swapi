package com.example.starwarsapi.di

import android.content.Context
import androidx.room.Room
import com.example.starwarsapi.feature.data.api.StarWarsApi
import com.example.starwarsapi.feature.data.database.FavoritePeopleDao
import com.example.starwarsapi.feature.data.database.StarWarsDatabase
import com.example.starwarsapi.feature.data.repositoryimpl.DatabaseRepositoryImpl
import com.example.starwarsapi.feature.data.repositoryimpl.SearchRepositoryImpl
import com.example.starwarsapi.feature.domain.repository.DatabaseRepository
import com.example.starwarsapi.feature.domain.repository.SearchRepository
import com.example.starwarsapi.feature.domain.usecase.impl.SearchUseCaseImpl
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
    fun providerStarWarsDataBase(context: Context) = Room
        .databaseBuilder(context, StarWarsDatabase::class.java, "StarWars")
        .build()

    @Provides
    fun provideSearchRepository(searApi: StarWarsApi) = SearchRepositoryImpl(searApi)

    @Provides
    fun provideFavoriteDao(database: StarWarsDatabase) = database.getFavoritePeopleDao()

    @Provides
    fun provideDataBaseRepository(dao: FavoritePeopleDao) = DatabaseRepositoryImpl(dao)

    @Provides
    fun provideSearchUseCase(
        searchRepository: SearchRepository,
        databaseRepository: DatabaseRepository
    ) = SearchUseCaseImpl(searchRepository, databaseRepository)

    companion object {
        private const val BASE_URL = "https://swapi.dev/api/"
    }
}