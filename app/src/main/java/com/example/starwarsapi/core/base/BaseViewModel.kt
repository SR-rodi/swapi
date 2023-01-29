package com.example.starwarsapi.core.base

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.starwarsapi.core.state.LoadState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<I : Any> : ViewModel() {

    protected val _data = MutableStateFlow(emptyList<I>())
    val data = _data.asStateFlow()

    private val _loadState = MutableStateFlow(LoadState.SUCCESS)
    val loadState = _loadState.asStateFlow()

    protected val handler = CoroutineExceptionHandler { _, T ->
        Log.e("Kart", "${T.message}")
        _loadState.value = LoadState.ERROR
    }

    protected suspend fun <A> getLoadState(action: suspend () -> A): A {
        _loadState.value = LoadState.LOADING
        val response = action()
        _loadState.value = LoadState.SUCCESS
        return response
    }
}