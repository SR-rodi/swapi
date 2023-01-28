package com.example.starwarsapi.core

import android.content.Context
import com.example.starwarsapi.app.App
import com.example.starwarsapi.di.AppComponent
import com.example.starwarsapi.feature.data.model.PeopleDto

fun List<PeopleDto>.toListPeople() = this.map { peopleDto -> peopleDto.toPeople() }


fun Context.appComponent(): AppComponent =
    when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent()
    }