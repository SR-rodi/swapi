package com.example.starwarsapi.core.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<I : Any, VH : RecyclerView.ViewHolder> :
    RecyclerView.Adapter<VH>() {

    private var items = listOf<I>()

    fun setList(list: List<I>) {
        items = list
    }

    protected fun getItem(position: Int) = items[position]

    override fun getItemCount() = items.size

}