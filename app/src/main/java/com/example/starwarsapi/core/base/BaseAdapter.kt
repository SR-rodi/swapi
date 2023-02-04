package com.example.starwarsapi.core.base

import androidx.recyclerview.widget.RecyclerView

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