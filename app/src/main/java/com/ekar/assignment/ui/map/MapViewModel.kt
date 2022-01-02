package com.ekar.assignment.ui.map

import androidx.lifecycle.viewModelScope
import com.ekar.assignment.core.base.BaseViewModel
import com.ekar.assignment.data.model.request.CarDetailRequest
import com.ekar.assignment.domain.usecase.GetCarDetail
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
class MapViewModel @Inject constructor(val getCarDetail: GetCarDetail) : BaseViewModel() {

    fun getCarDetail(key: String, vin: String) {
        viewModelScope.launch {
            request(
                flow = getCarDetail(CarDetailRequest(key = key, vin = vin)),
                onSuccess = {

                })
        }
    }
}