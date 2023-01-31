package com.example.starwarsapi.feature.data.database


import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritePeopleDao {

    @Query("SELECT*From people_favorite")
    @MapInfo(keyColumn = "name")
    fun getAllPeople(): Flow<Map<String, FavoritePeopleEntity>>

    @Query("SELECT *FROM people_favorite WHERE name=:name")
    fun getPeopleByName(name: String): Flow<FavoritePeopleEntity?>

    @Insert
    fun insert(people: FavoritePeopleEntity)

    @Delete
    fun deletePeople(people: FavoritePeopleEntity)

}