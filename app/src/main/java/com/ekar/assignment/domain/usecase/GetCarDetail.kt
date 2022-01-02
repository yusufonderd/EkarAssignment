package com.ekar.assignment.domain.usecase

import com.ekar.assignment.core.domain.UseCase
import com.ekar.assignment.core.network.RestResult
import com.ekar.assignment.core.network.map
import com.ekar.assignment.data.model.request.CarDetailRequest
import com.ekar.assignment.data.repository.CarDetailRepository
import com.ekar.assignment.domain.mapper.CarSpecUIModelMapper
import com.ekar.assignment.domain.uimodel.CarDetailUIModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */

class GetCarDetail @Inject constructor(
    private val repository: CarDetailRepository,
    private val mapper: CarSpecUIModelMapper
) : UseCase<CarDetailRequest, RestResult<CarDetailUIModel>> {

    override suspend fun invoke(input: CarDetailRequest) =
        repository(input).map { networkState ->
            networkState.map { authResponse ->
                mapper.map(authResponse)
            }
        }
}