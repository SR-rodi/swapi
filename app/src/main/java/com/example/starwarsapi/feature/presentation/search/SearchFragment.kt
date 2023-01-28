package com.example.starwarsapi.feature.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.starwarsapi.core.base.BaseFragment
import com.example.starwarsapi.core.extantions.appComponent
import com.example.starwarsapi.core.extantions.setTextChangeListener
import com.example.starwarsapi.core.state.ItemClickState
import com.example.starwarsapi.databinding.FragmentSearchBinding
import com.example.starwarsapi.feature.presentation.search.adapter.SearchAdapter
import com.example.starwarsapi.feature.presentation.search.model.PeopleUi

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentSearchBinding.inflate(inflater)

    private val viewModel by viewModels<SearchViewModel> { requireContext().appComponent().viewModelFactory }

    private val adapter by lazy { SearchAdapter { onClick(it) } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editSearch.setTextChangeListener { query -> viewModel.startSearch(query) }

        dataObserve(viewModel.data) { peoples -> setAdapter(peoples) }

    }

    private fun setAdapter(peopleList: List<PeopleUi>) {
        adapter.setList(peopleList)
        binding.recyclerView.adapter = adapter
    }

    private fun onClick(clickState: ItemClickState) {
        when (clickState) {
            ItemClickState.FAVORITE ->viewModel.workDatabase(clickState.people)
            ItemClickState.ROOT ->
                Toast.makeText(requireContext(), "Root", Toast.LENGTH_SHORT).show()
        }
    }
}