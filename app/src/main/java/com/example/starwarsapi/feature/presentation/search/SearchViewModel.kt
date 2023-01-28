package com.example.starwarsapi.feature.presentation.search

import androidx.lifecycle.ViewModel
import com.example.starwarsapi.feature.domain.repository.SearchRepository
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

}