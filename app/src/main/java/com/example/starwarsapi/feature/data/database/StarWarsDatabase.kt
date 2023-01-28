package com.example.starwarsapi.feature.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoritePeopleEntity::class], version = 1 )
abstract class StarWarsDatabase:RoomDatabase() {

    abstract fun getFavoritePeopleDao():FavoritePeopleDao
}