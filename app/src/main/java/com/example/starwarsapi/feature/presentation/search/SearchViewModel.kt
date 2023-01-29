package com.example.starwarsapi.feature.presentation.search

import androidx.lifecycle.viewModelScope
import com.example.starwarsapi.core.base.BaseViewModel
import com.example.starwarsapi.core.extantions.toListPeopleUi
import com.example.starwarsapi.feature.domain.usecase.FavoriteUseCase
import com.example.starwarsapi.feature.domain.usecase.SearchUseCase
import com.example.starwarsapi.feature.presentation.search.model.PeopleUi
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
    private val favoriteUseCase: FavoriteUseCase,
) : BaseViewModel<PeopleUi>() {

    private val query = MutableStateFlow("")

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val peoples = query.debounce(500)
        .flatMapLatest { name -> getPeopleByName(name) }
        .stateIn(viewModelScope + Dispatchers.IO + handler, SharingStarted.Lazily, emptyList())

    fun setQuery(text: String) {
        query.value = text
    }

    fun workDatabase(item: PeopleUi?) =
        viewModelScope.launch(Dispatchers.IO + handler) {
            if (item != null)
                favoriteUseCase.workDataBase(item.toFavoritePeople(), item.favorite)
        }

    private suspend fun getPeopleByName(name: String) = getLoadState {
        searchUseCase.getPeopleByName(name).map { people -> people.toListPeopleUi() }
    }

}