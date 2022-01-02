package com.ekar.assignment.data.repository

import com.ekar.assignment.core.network.BaseRepository
import com.ekar.assignment.data.api.ApiService
import com.ekar.assignment.data.model.request.CarDetailRequest
import com.ekar.assignment.di.coroutine.CoroutineThread
import javax.inject.Inject

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */

class CarDetailRepository @Inject constructor(
    private val api: ApiService,
    private val coroutineThread: CoroutineThread
) : BaseRepository() {

    suspend operator fun invoke(request: CarDetailRequest) =
        safeApiCall(dispatcher = coroutineThread.io) {
            api.getSpecs(
                key = request.key,
                vin = request.vin
            )
        }
}