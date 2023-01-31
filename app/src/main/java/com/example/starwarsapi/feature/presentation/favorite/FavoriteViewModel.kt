package com.example.starwarsapi.feature.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsapi.feature.domain.repository.database.FavoriteDbRepository
import com.example.starwarsapi.feature.domain.usecase.FavoriteUseCase
import com.example.starwarsapi.feature.domain.usecase.LikeUseCase
import com.example.starwarsapi.feature.presentation.search.model.PeopleUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    favoriteRepository: FavoriteUseCase,
    private val likeUseCase: LikeUseCase
) : ViewModel() {

    val peoples = favoriteRepository.getFavoritePeople().map { map ->
        map.map { it.value.toFavoritePeopleUi() }
    }.stateIn(viewModelScope + Dispatchers.IO, SharingStarted.Lazily, emptyList())

    fun delete(item:PeopleUi){
        viewModelScope.launch(Dispatchers.IO) {
            likeUseCase.workDataBase(item.toFavoritePeople(),true)
        }
    }
}