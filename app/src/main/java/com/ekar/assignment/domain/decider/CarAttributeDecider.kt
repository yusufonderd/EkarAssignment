package com.ekar.assignment.domain.decider

import com.ekar.assignment.data.model.response.CarDetailAttributeResponse
import java.lang.StringBuilder
import javax.inject.Inject

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
class CarAttributeDecider @Inject constructor() {

    fun provideCarModel(carAttribute : CarDetailAttributeResponse) : String{
        val modelBuilder = StringBuilder()
        modelBuilder.append(carAttribute.make)
        modelBuilder.append(carAttribute.model)
        return modelBuilder.toString()
    }
}