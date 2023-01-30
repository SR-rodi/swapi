package com.example.starwarsapi.feature.presentation.search

import androidx.lifecycle.viewModelScope
import com.example.starwarsapi.core.base.BaseViewModel
import com.example.starwarsapi.core.extantions.Log
import com.example.starwarsapi.core.extantions.toListPeopleUi
import com.example.starwarsapi.core.state.LoadState
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

    private val query = MutableStateFlow(SPACE)

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    var peoples = query.debounce(500)
        .flatMapLatest { name -> getPeopleByName(name) }
        .stateIn(viewModelScope + Dispatchers.IO, SharingStarted.Lazily, emptyList())

    fun setQuery(text: String) {
        query.value = text
    }

    fun workDatabase(item: PeopleUi?) =
        viewModelScope.launch(Dispatchers.IO + handler) {
            if (item != null)
                favoriteUseCase.workDataBase(item.toFavoritePeople(), item.favorite)
        }

    private suspend fun getPeopleByName(name: String) = getLoadState {
        if (name == SPACE) flowOf(emptyList())
        else try {
            searchUseCase.getPeopleByName(name).map { people ->
                if (people.isEmpty()) _loadState.value = LoadState.EMPTY
                people.toListPeopleUi()
            }
        } catch (e: Exception) {
            _loadState.value = LoadState.ERROR
            flowOf(emptyList())
        }
    }

    companion object {
        private const val SPACE = ""
    }
}