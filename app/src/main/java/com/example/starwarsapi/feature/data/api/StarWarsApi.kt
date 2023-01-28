package com.example.starwarsapi.feature.data.api

import com.example.starwarsapi.feature.data.model.ResponsePeopleDto
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsApi {

    @GET("people/")
    suspend fun searchPeopleForName(@Query("search") name: String): ResponsePeopleDto
}