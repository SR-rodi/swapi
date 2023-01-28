package com.example.starwarsapi.feature.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import com.example.starwarsapi.core.BaseFragment
import com.example.starwarsapi.core.appComponent
import com.example.starwarsapi.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentSearchBinding.inflate(inflater)

    private val viewModel by viewModels<SearchViewModel>{requireContext().appComponent().viewModelFactory}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel

    }

}