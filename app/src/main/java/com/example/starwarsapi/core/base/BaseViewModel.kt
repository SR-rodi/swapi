package com.example.starwarsapi.core.base

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.starwarsapi.core.state.LoadState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel : ViewModel() {


    protected val _loadState = MutableStateFlow(LoadState.SUCCESS)
    val loadState = _loadState.asStateFlow()

    protected val handler = CoroutineExceptionHandler { _, error ->
        Log.e("Kart", "${error}")
        _loadState.value = LoadState.ERROR
    }

    protected suspend fun <A> getLoadState( plug: A,action: suspend () -> A): A {
        _loadState.value = LoadState.LOADING
        var response = plug
        kotlin.runCatching { action() }.fold(
            onSuccess = { response = it },
            onFailure = { _loadState.value = LoadState.ERROR }
        )
        if (_loadState.value != LoadState.LOADING) changeLoadState()
        else _loadState.value = LoadState.SUCCESS
        return response
    }

    private fun changeLoadState() {
        val state = _loadState.value
        _loadState.value = LoadState.SUCCESS
        _loadState.value = state
    }
}