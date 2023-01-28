package com.example.starwarsapi.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.starwarsapi.core.state.LoadState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseFragment<B : ViewBinding> : Fragment() {

    private var _binding: B? = null
    protected val binding get() = _binding!!

    protected abstract fun initBinding(inflater: LayoutInflater): B?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = initBinding(inflater)
        return binding.root
    }

    protected fun loadStateObserve(stateflow: Flow<LoadState>) {
        viewLifecycleOwner.lifecycleScope.launch {
            stateflow.collect { state ->

            }
        }
    }

    protected fun <I> dataObserve(flow: Flow<I>, block: (data: I) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            flow.collect { data ->
                block(data)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}