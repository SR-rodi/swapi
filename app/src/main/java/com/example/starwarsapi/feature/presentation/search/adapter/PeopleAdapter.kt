package com.example.starwarsapi.feature.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.starwarsapi.core.base.BaseAdapter
import com.example.starwarsapi.core.state.ItemClickState
import com.example.starwarsapi.databinding.ItemSearchPeopleBinding
import com.example.starwarsapi.feature.presentation.search.adapter.holder.SearchViewHolder
import com.example.starwarsapi.feature.presentation.search.model.PeopleUi

class PeopleAdapter (
    private val onClick:(state:ItemClickState)->Unit
        ): BaseAdapter<PeopleUi, SearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(
        ItemSearchPeopleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position)){ onClick(it) }
    }
}