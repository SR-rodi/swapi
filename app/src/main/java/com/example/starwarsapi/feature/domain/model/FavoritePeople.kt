package com.example.starwarsapi.feature.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class FavoritePeople(
    val birthYear: String,
    val gender: String,
    val name: String
)