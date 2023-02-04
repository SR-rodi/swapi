package com.example.starwarsapi.core.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T : Any>(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    protected var item: T? = null

    abstract fun bind(item: T)

}