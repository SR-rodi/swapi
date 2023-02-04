package com.example.starwarsapi.core.base

import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapi.feature.presentation.search.adapter.holder.BaseViewHolder

abstract class BaseAdapter<I : Any, VH : BaseViewHolder<I>> :
    RecyclerView.Adapter<VH>() {

    private var items = listOf<I>()

    fun setList(list: List<I>) {
        items = list
    }

    private fun getItem(position: Int) = items[position]

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

}