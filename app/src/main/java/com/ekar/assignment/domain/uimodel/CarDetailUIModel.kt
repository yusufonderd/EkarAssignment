package com.ekar.assignment.domain.uimodel

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
data class CarDetailUIModel(
    val make : String,
    val model : String,
    val style : String,
    val colors: List<String>,
    val year: String,
    val formattedYear : String,
    val seat : String,
    val deliveryCharges: String,
    val bookingFee : String,
    val currency: String
)