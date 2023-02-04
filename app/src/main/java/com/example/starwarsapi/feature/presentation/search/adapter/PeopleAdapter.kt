package com.example.starwarsapi.feature.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.starwarsapi.core.base.BaseAdapter
import com.example.starwarsapi.core.base.BaseViewHolder
import com.example.starwarsapi.core.state.ItemClickState
import com.example.starwarsapi.databinding.ItemSearchPeopleBinding
import com.example.starwarsapi.feature.presentation.search.adapter.holder.SearchViewHolder
import com.example.starwarsapi.feature.presentation.model.PeopleUi

class PeopleAdapter(
    private val onClick: (state: ItemClickState) -> Unit,
) : BaseAdapter<PeopleUi, BaseViewHolder<PeopleUi>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(
        ItemSearchPeopleBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
    ) { stateClick -> onClick(stateClick) }

}