package com.example.starwarsapi.di.module

import android.content.Context
import androidx.room.Room
import com.example.starwarsapi.feature.data.database.StarWarsDatabase
import dagger.Provides
import javax.inject.Singleton

@dagger.Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providerStarWarsDataBase(context: Context) = Room
        .databaseBuilder(context, StarWarsDatabase::class.java, DATABASE_NAME)
        .build()

    @Provides
    @Singleton
    fun provideFavoriteDao(database: StarWarsDatabase) = database.getFavoritePeopleDao()

    companion object {
        private const val DATABASE_NAME = "StarWars"
    }
}