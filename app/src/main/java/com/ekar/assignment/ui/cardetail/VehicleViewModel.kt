package com.ekar.assignment.ui.cardetail

import androidx.lifecycle.viewModelScope
import com.ekar.assignment.core.base.BaseViewModel
import com.ekar.assignment.data.model.request.CarDetailRequest
import com.ekar.assignment.domain.uimodel.CarDetailUIModel
import com.ekar.assignment.domain.usecase.GetCarDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */

const val DEFAULT_KEY_VALUE = "tha91z6lv_j8u1nv4xs_ilfswb1e3"
const val DEFAULT_VIN_VALUE = "JTDZN3EU0E3298500"

@HiltViewModel
class CarDetailViewModel @Inject constructor(private val carDetail: GetCarDetail) :
    BaseViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun getCarDetail(key: String = DEFAULT_KEY_VALUE, vin: String = DEFAULT_VIN_VALUE) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            request(
                flow = carDetail(CarDetailRequest(key = key, vin = vin)),
                onSuccess = { carDetail ->
                    _uiState.update { it.copy(carDetail = carDetail, isLoading = false) }
                })
        }
    }

    data class UiState(
        val isLoading: Boolean = true,
        val carDetail: CarDetailUIModel? = null
    )
}