package com.example.starwarsapi.feature.presentation.search

import androidx.lifecycle.viewModelScope
import com.example.starwarsapi.core.base.BaseViewModel
import com.example.starwarsapi.core.state.LoadState
import com.example.starwarsapi.core.extantions.toListPeopleUi
import com.example.starwarsapi.feature.domain.usecase.SearchUseCase
import com.example.starwarsapi.feature.presentation.search.model.PeopleUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : BaseViewModel<PeopleUi>() {

    private var job: Job = Job()

    fun startSearch(name: String) {
        job.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            delay(500)
            _loadState.value = LoadState.LOADING
            _data.value = searchUseCase.getPeopleByName(name).toListPeopleUi()
            _loadState.value = LoadState.SUCCESS
        }
    }
}