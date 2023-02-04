package com.example.starwarsapi.feature.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.starwarsapi.core.base.BaseFragment
import com.example.starwarsapi.core.extantions.setTextChangeListener
import com.example.starwarsapi.core.state.ItemClickState
import com.example.starwarsapi.core.state.LoadState
import com.example.starwarsapi.databinding.FragmentSearchBinding
import com.example.starwarsapi.feature.presentation.search.adapter.PeopleAdapter
import com.example.starwarsapi.feature.presentation.model.PeopleUi

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentSearchBinding.inflate(inflater)

    private val viewModel by lazy { initViewModel<SearchViewModel>() }

    private val adapter by lazy { PeopleAdapter { onClick(it) } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editSearch.setTextChangeListener { query -> viewModel.setQuery(query) }

        dataObserve(viewModel.peoples) { peoples -> setAdapter(peoples) }

        dataObserve(viewModel.loadState) { state -> loadStateListener(state) }

    }

    private fun loadStateListener(state: LoadState) {
        binding.loading.isVisible = state == LoadState.LOADING
        binding.emptyList.isVisible = state == LoadState.EMPTY
        binding.error.isVisible = state == LoadState.ERROR
    }

    private fun setAdapter(peopleList: List<PeopleUi>) {
        adapter.setList(peopleList)
        binding.recyclerView.adapter = adapter
    }

    private fun onClick(clickState: ItemClickState) {
        val item = requireNotNull(clickState.people)
        when (clickState) {
            ItemClickState.FAVORITE -> viewModel.workDatabase(item)
            ItemClickState.ROOT -> findNavController().navigate(
                SearchFragmentDirections.actionNavigationHomeToDetailsPeopleFragment(item.url)
            )
        }
    }
}