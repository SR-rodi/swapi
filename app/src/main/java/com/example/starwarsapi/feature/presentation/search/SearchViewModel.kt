package com.example.starwarsapi.feature.presentation.search

import androidx.lifecycle.viewModelScope
import com.example.starwarsapi.core.base.BaseViewModel
import com.example.starwarsapi.core.extantions.toListPeopleUi
import com.example.starwarsapi.core.state.LoadState
import com.example.starwarsapi.feature.domain.usecase.FavoriteUseCase
import com.example.starwarsapi.feature.domain.usecase.SearchUseCase
import com.example.starwarsapi.feature.presentation.search.model.PeopleUi
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
    private val favoriteUseCase: FavoriteUseCase,
) : BaseViewModel<PeopleUi>() {

    private var job: Job = Job()

    fun startSearch(name: String) {
        job.cancel()
        job = viewModelScope.launch(Dispatchers.IO + handler) {
            delay(500)
            _loadState.value = LoadState.LOADING
            searchUseCase.getPeopleByName(name).onEach {
                _data.value = it.toListPeopleUi()
                _loadState.value = LoadState.SUCCESS
            }.launchIn(viewModelScope + Dispatchers.IO + handler)
        }
    }

    fun workDatabase(item: PeopleUi?) =
        viewModelScope.launch(Dispatchers.IO + handler) {
            if (item != null)
                favoriteUseCase.workDataBase(item.toFavoritePeople(), item.favorite)
        }
}