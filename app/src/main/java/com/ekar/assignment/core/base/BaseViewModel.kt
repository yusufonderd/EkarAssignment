package com.ekar.assignment.core.base

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekar.assignment.core.network.RestResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    fun <T> request(
        flow: Flow<RestResult<T>>,
        onSuccess: ((data: T) -> Unit)? = null,
        onError: ((t: Exception) -> Unit)? = null,
        onLoading: (() -> Unit)? = null
    ) = viewModelScope.launch {
        flow.collect { result ->
            when (result) {
                is RestResult.Loading -> onLoading?.invoke()
                is RestResult.Success -> onSuccess?.invoke(result.data)
                is RestResult.Error -> { onError?.invoke(result.exception) }
            }
        }
    }
}