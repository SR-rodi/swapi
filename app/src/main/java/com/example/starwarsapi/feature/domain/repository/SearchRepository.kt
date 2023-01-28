package com.example.starwarsapi.feature.domain.repository

import com.example.starwarsapi.feature.domain.model.People

interface SearchRepository {

   suspend fun getPeopleByName(name: String):List<People>
}