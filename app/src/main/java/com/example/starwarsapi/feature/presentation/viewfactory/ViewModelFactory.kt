package com.example.starwarsapi.feature.presentation.viewfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.starwarsapi.feature.domain.usecase.DetailsUseCase
import com.example.starwarsapi.feature.domain.usecase.FavoriteUseCase
import com.example.starwarsapi.feature.domain.usecase.LikeUseCase
import com.example.starwarsapi.feature.domain.usecase.SearchUseCase
import com.example.starwarsapi.feature.presentation.details.DetailsPeopleViewModel
import com.example.starwarsapi.feature.presentation.favorite.FavoriteViewModel
import com.example.starwarsapi.feature.presentation.search.SearchViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val searchUseCase: SearchUseCase,
    private val likeUseCase: LikeUseCase,
    private val detailsUseCase: DetailsUseCase,
    private val favoriteUseCase: FavoriteUseCase,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            SearchViewModel::class.java -> SearchViewModel(searchUseCase, likeUseCase) as T
            FavoriteViewModel::class.java -> FavoriteViewModel(favoriteUseCase, likeUseCase) as T
            DetailsPeopleViewModel::class.java ->
                DetailsPeopleViewModel(detailsUseCase, likeUseCase) as T
            else -> throw IllegalStateException("no ViewModelProvider")
        }
    }
}