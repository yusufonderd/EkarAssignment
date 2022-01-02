package com.ekar.assignment.data.model.response

import com.google.gson.annotations.SerializedName

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
data class CarDetailResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("attributes") val attributes: CarDetailAttributeResponse,
    @SerializedName("colors") val colors: List<CarDetailColorResponse>
)
data class CarDetailColorResponse(
    @SerializedName("name") val name: String
)
data class CarDetailAttributeResponse(
    @SerializedName("year") val year: String?,
    @SerializedName("model") val model: String?,
    @SerializedName("make") val make: String?,
    @SerializedName("style") val style: String?,
    @SerializedName("delivery_charges") val deliveryCharges: String?,
    @SerializedName("standard_seating") val seating: String?

)