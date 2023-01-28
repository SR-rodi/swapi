package com.example.starwarsapi.feature.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.starwarsapi.feature.domain.model.FavoritePeople

@Entity(tableName = "people_favorite")
class FavoritePeopleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "birth_year")
    val birthYear: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "name")
    val name: String
){
    fun toFavoritePeople()= FavoritePeople(id,birthYear, gender, name)
}