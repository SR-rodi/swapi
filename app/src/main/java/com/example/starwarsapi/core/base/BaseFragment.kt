package com.example.starwarsapi.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.starwarsapi.core.extantions.appComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment<B : ViewBinding> : Fragment() {

    private var _binding: B? = null
    protected val binding get() = _binding!!

    protected abstract fun initBinding(inflater: LayoutInflater): B?

    inline fun <reified VM : ViewModel> initViewModel(): VM {
        val viewModel by viewModels<VM> { requireContext().appComponent().viewModelFactory }
        return viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = initBinding(inflater)
        return binding.root
    }

    protected fun <I> dataObserve(flow: Flow<I>, block: suspend (data: I) -> Unit) {
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