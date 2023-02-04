package com.example.starwarsapi.feature.presentation.search.adapter.holder

import com.example.starwarsapi.R
import com.example.starwarsapi.core.base.BaseViewHolder
import com.example.starwarsapi.core.extantions.setText
import com.example.starwarsapi.core.state.ItemClickState
import com.example.starwarsapi.databinding.ItemSearchPeopleBinding
import com.example.starwarsapi.feature.presentation.model.PeopleUi

class SearchViewHolder(
    private val binding: ItemSearchPeopleBinding,
    private val onClick: (state: ItemClickState) -> Unit,
) : BaseViewHolder<PeopleUi>(binding) {

    init {
        binding.apply {
            favorite.setOnClickListener {
                onClick(ItemClickState.FAVORITE.apply { people = item })
            }
            root.setOnClickListener { onClick(ItemClickState.ROOT.apply { people = item }) }
        }
    }

    override fun bind(item: PeopleUi) {
        this.item = item
        binding.apply {
            name.text = item.name
            birth.setText(R.string.date_oo_birth, item.birthYear)
            gender.setText(R.string.gender, item.gender)
            favorite.isSelected = item.favorite
        }
    }
}