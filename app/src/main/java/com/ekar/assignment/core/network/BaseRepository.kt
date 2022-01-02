package com.ekar.assignment.core.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import java.io.IOException

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */

abstract class BaseRepository {

    fun <T : Any> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        call: suspend () -> Response<T>
    ): Flow<RestResult<T>> =
        flow {
            emit(RestResult.Loading)
            val response = call.invoke()
            val responseBody = response.body()
            if (response.isSuccessful && responseBody != null) {
                emit(RestResult.Success(responseBody))
            } else {
                val responseError = response.errorBody()
                if (responseError != null) {
                    emit(RestResult.Error(IOException(responseError.toString())))
                } else {
                    emit(RestResult.Error(IOException("Unknown error")))
                }
            }
        }.catch { error ->
            error.printStackTrace()
            emit(RestResult.Error(Exception(error)))
        }.flowOn(dispatcher)
}
