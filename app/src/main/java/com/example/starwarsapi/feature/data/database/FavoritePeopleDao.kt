package com.example.starwarsapi.feature.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoritePeopleDao {

    @Query("SELECT * FROM people_favorite")
    fun getAllPeople(): List<FavoritePeopleEntity>

    @Insert
    fun insert(peopleUrl: FavoritePeopleEntity)

    @Delete
    fun deletePeopleUrl(peopleUrl: FavoritePeopleEntity)

    @Query("DELETE FROM people_favorite")
    fun deleteAll()

}