package com.ekar.assignment.domain.mapper

import com.ekar.assignment.core.domain.Mapper
import com.ekar.assignment.data.model.response.CarDetailResponse
import com.ekar.assignment.domain.decider.CarAttributeDecider
import com.ekar.assignment.domain.uimodel.CarDetailUIModel
import java.lang.StringBuilder
import javax.inject.Inject

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
class CarSpecUIModelMapper @Inject constructor(
   private var decider: CarAttributeDecider
) : Mapper<CarDetailResponse, CarDetailUIModel> {

    override fun map(input: CarDetailResponse): CarDetailUIModel {
        val attributes = input.attributes
        return CarDetailUIModel(model = decider.provideCarModel(attributes))
    }

}