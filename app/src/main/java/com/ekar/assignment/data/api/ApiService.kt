package com.ekar.assignment.data.api

import com.ekar.assignment.data.model.response.CarDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
interface ApiService {

    @GET("specs")
    suspend fun getSpecs(
        @Query("key") key: String,
        @Query("vin") vin: String
    ): Response<CarDetailResponse>
}
