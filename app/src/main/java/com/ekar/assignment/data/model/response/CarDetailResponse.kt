package com.ekar.assignment.data.model.response

import com.google.gson.annotations.SerializedName

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
data class CarDetailResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("attributes") val attributes: CarDetailAttributeResponse

)

data class CarDetailAttributeResponse(
    @SerializedName("year") val year: String,
    @SerializedName("model") val model: String,
    @SerializedName("make") val make: String
)