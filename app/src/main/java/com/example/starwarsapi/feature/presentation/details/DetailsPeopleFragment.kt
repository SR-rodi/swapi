package com.example.starwarsapi.feature.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.example.starwarsapi.core.base.BaseFragment
import com.example.starwarsapi.core.state.LoadState
import com.example.starwarsapi.databinding.FragmentDetailsPeopleBinding
import com.example.starwarsapi.feature.presentation.details.model.DetailsPeople

class DetailsPeopleFragment : BaseFragment<FragmentDetailsPeopleBinding>() {
    override fun initBinding(inflater: LayoutInflater) =
        FragmentDetailsPeopleBinding.inflate(inflater)

    private val people by navArgs<DetailsPeopleFragmentArgs>()

    private val viewModel by lazy { initViewModel<DetailsPeopleViewModel>() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setUrl(people.url)

        dataObserve(viewModel.people) { man ->
            bind(man)
            favoriteClick(man)
        }

        dataObserve(viewModel.loadState){ state->
            binding.error.isVisible = state == LoadState.ERROR
            binding.loading.isVisible = state == LoadState.LOADING
        }

    }

    private fun favoriteClick(info: DetailsPeople) =
        binding.favorite.setOnClickListener {
            viewModel.workDataBase(info)
        }

    private fun bind(man: DetailsPeople) =
        binding.apply {
            name.text = man.name
            birthDay.text = man.birthYear
            gender.text = man.gender
            mass.text = man.mass
            favorite.isSelected = man.isFavorite
        }

}