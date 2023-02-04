package com.example.starwarsapi.feature.presentation.favorite

import androidx.lifecycle.viewModelScope
import com.example.starwarsapi.core.base.BaseViewModel
import com.example.starwarsapi.feature.domain.usecase.FavoriteUseCase
import com.example.starwarsapi.feature.domain.usecase.LikeUseCase
import com.example.starwarsapi.feature.presentation.model.PeopleUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    favoriteRepository: FavoriteUseCase,
    private val likeUseCase: LikeUseCase,
) : BaseViewModel() {

    val peoples = favoriteRepository.getFavoritePeople().map { flowMapFavorite ->
        getLoadState(emptyList()) {
            flowMapFavorite.map { favorite -> favorite.value.toFavoritePeopleUi() }
        }
    }.stateIn(viewModelScope + Dispatchers.IO, SharingStarted.Lazily, emptyList())

    fun delete(item: PeopleUi) =
        viewModelScope.launch(Dispatchers.IO) {
            likeUseCase.workDataBase(item.toFavoritePeople(), true)
        }
}