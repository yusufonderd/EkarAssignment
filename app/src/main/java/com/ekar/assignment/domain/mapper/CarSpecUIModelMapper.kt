package com.ekar.assignment.domain.mapper

import com.ekar.assignment.core.domain.Mapper
import com.ekar.assignment.data.model.response.CarDetailResponse
import com.ekar.assignment.domain.decider.CarAttributeDecider
import com.ekar.assignment.domain.uimodel.CarDetailUIModel
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
        val colors = input.colors.map { it.name }
        return CarDetailUIModel(
            make = attributes.make.orEmpty(),
            style = attributes.style.orEmpty(),
            model = attributes.model.orEmpty(),
            colors = colors,
            deliveryCharges = attributes.deliveryCharges.orEmpty(),
            seat = attributes.seating.orEmpty(),
            year = attributes.year.orEmpty(),
            formattedYear = decider.provideYear(attributes),
            //I use mock data for ui because of no required data coming from service
            bookingFee = "120",
            currency = "AED"
        )
    }

}