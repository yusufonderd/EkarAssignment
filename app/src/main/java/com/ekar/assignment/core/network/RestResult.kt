package com.ekar.assignment.core.network

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */

sealed class RestResult<out T> {

    class Success<T>(val data: T) : RestResult<T>()

    class Error(val exception: Exception) : RestResult<Nothing>()

    object Loading : RestResult<Nothing>()

    fun onSuccess(handler: (T) -> Unit): RestResult<T> = this.also {
        if (this is Success) handler(data)
    }

    fun onLoading(handler: () -> Unit): RestResult<T> = this.also {
        if (this is Loading) handler()
    }

    fun onError(handler: (t: Exception) -> Unit): RestResult<T> = this.also {
        if (this is Error) handler(exception)
    }

    fun getValue(): T? = (this as Success).data
}

fun <T, R> RestResult<T>.map(transform: (T) -> R): RestResult<R> {
    return when (this) {
        is RestResult.Success -> RestResult.Success(transform(data))
        is RestResult.Error -> RestResult.Error(exception)
        is RestResult.Loading -> RestResult.Loading
    }
}
