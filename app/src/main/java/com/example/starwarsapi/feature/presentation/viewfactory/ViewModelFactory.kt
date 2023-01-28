package com.example.starwarsapi.feature.presentation.viewfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.starwarsapi.feature.domain.repository.SearchRepository
import com.example.starwarsapi.feature.presentation.search.SearchViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            SearchViewModel::class.java -> SearchViewModel(searchRepository) as T
            else -> throw IllegalStateException("no ViewModelProvider")
        }
    }
}