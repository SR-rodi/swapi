package com.example.starwarsapi.feature.presentation.details

import androidx.lifecycle.viewModelScope
import com.example.starwarsapi.core.base.BaseViewModel
import com.example.starwarsapi.feature.domain.usecase.DetailsUseCase
import com.example.starwarsapi.feature.domain.usecase.LikeUseCase
import com.example.starwarsapi.feature.presentation.details.model.DetailsPeople
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class DetailsPeopleViewModel @Inject constructor(
    private val detailsUseCase: DetailsUseCase,
    private val likeUseCase: LikeUseCase
) : BaseViewModel() {

    private val url = MutableStateFlow("")

    @OptIn(ExperimentalCoroutinesApi::class)
    val people = url.flatMapLatest { url ->
        getLoadState(flowOf(PLUG_DETAILS)) {
            detailsUseCase.getDetailsInfo(url).map { people -> people.toDetails() }
        }
    }.stateIn(viewModelScope + Dispatchers.IO, SharingStarted.Lazily, PLUG_DETAILS)

    fun setUrl(newUrl: String) {
        url.value = newUrl
    }

    fun workDataBase(item: DetailsPeople)=
        viewModelScope.launch (Dispatchers.IO){
            likeUseCase.workDataBase(item.toFavorite(), item.isFavorite)
        }

    companion object {
        private val PLUG_DETAILS = DetailsPeople()
    }

}