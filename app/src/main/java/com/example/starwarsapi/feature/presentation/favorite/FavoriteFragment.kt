package com.example.starwarsapi.feature.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.starwarsapi.core.base.BaseFragment
import com.example.starwarsapi.core.state.ItemClickState
import com.example.starwarsapi.databinding.FragmentFavoriteBinding
import com.example.starwarsapi.feature.presentation.search.adapter.PeopleAdapter
import com.example.starwarsapi.feature.presentation.model.PeopleUi

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentFavoriteBinding.inflate(inflater)

    private val viewModel by lazy { initViewModel<FavoriteViewModel>() }

    private val adapter by lazy { PeopleAdapter { onItemClick(it) } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataObserve(viewModel.peoples) { peoples -> setAdapter(peoples) }
    }

    private fun setAdapter(peoples: List<PeopleUi>) {
        adapter.setList(peoples)
        binding.recyclerView.adapter = adapter
    }

    private fun onItemClick(state: ItemClickState) {
        val item = requireNotNull(state.people)
        when (state) {
            ItemClickState.FAVORITE -> viewModel.delete(item)
            ItemClickState.ROOT -> findNavController().navigate(
                FavoriteFragmentDirections
                    .actionNavigationDashboardToDetailsPeopleFragment(item.url)
            )
        }
    }

}