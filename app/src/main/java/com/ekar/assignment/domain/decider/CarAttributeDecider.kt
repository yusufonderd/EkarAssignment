package com.ekar.assignment.domain.decider

import android.content.Context
import com.ekar.assignment.R
import com.ekar.assignment.data.model.response.CarDetailAttributeResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import java.lang.StringBuilder
import javax.inject.Inject

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
const val HYPHEN = " - "

class CarAttributeDecider @Inject constructor(@ApplicationContext private val context: Context) {

    fun provideYear(carAttribute: CarDetailAttributeResponse): String {
        val modelBuilder = StringBuilder()
        modelBuilder.append(context.getString(R.string.year))
        modelBuilder.append(HYPHEN)
        modelBuilder.append(carAttribute.year)
        return modelBuilder.toString()
    }
}