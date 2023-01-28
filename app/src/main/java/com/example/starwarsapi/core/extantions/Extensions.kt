package com.example.starwarsapi.core.extantions

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.example.starwarsapi.app.App
import com.example.starwarsapi.di.AppComponent
import com.example.starwarsapi.feature.data.database.FavoritePeopleEntity
import com.example.starwarsapi.feature.data.model.PeopleDto
import com.example.starwarsapi.feature.domain.model.People
import com.example.starwarsapi.feature.presentation.search.model.PeopleUi
import com.google.android.material.textfield.TextInputEditText

fun List<PeopleDto>.toListPeople() = this.map { peopleDto -> peopleDto.toPeople() }

fun List<FavoritePeopleEntity>.toListFavorite() =
    this.map { peopleEntity -> peopleEntity.toFavoritePeople() }

fun List<People>.toListPeopleUi() = this.map { people -> people.toPeopleUi() }

fun People.toPeopleUi() = PeopleUi(birthYear, url, gender, name)

@SuppressLint("SetTextI18n")
fun TextView.setText(rId: Int, text: String) {
    this.text = "${context.getText(rId)} $text"
}

fun TextInputEditText.setTextChangeListener(action: (text: String) -> Unit) {
    doOnTextChanged { text, _, _, _ ->
        action(text.toString())
    }
}

fun Context.appComponent(): AppComponent =
    when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent()
    }