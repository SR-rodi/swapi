package com.example.starwarsapi.feature.data.api

import com.example.starwarsapi.feature.data.model.PeopleDto
import com.example.starwarsapi.feature.data.model.ResponsePeopleDto
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface StarWarsApi {

    @GET("people/")
    suspend fun searchPeopleForName(@Query("search") name: String): ResponsePeopleDto

    @GET
    suspend fun getPeopleFromUrl(@Url url: String): PeopleDto
}