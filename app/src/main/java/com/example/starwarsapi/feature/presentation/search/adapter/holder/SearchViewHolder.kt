package com.example.starwarsapi.feature.presentation.search.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapi.R
import com.example.starwarsapi.core.extantions.setText
import com.example.starwarsapi.core.state.ItemClickState
import com.example.starwarsapi.databinding.ItemSearchPeopleBinding
import com.example.starwarsapi.feature.presentation.search.model.PeopleUi

class SearchViewHolder(private val binding: ItemSearchPeopleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PeopleUi, onClick: (state: ItemClickState) -> Unit) {
        binding.apply {
            name.text = item.name
            birth.setText(R.string.date_oo_birth, item.birthYear)
            gender.setText(R.string.gender, item.gender)

            favorite.setOnClickListener { onClick(ItemClickState.FAVORITE) }
            root.setOnClickListener { onClick(ItemClickState.ROOT) }
        }
    }
}