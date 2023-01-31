package com.example.starwarsapi.feature.domain.repository.network

import com.example.starwarsapi.feature.domain.model.People

interface NetworkRepository {

    suspend fun getPeopleByName(name: String): List<People>

    suspend fun getDetailsPeopleByUrl(url: String): People
}