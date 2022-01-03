package com.ekar.assignment.ui.splash

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.viewModelScope
import com.ekar.assignment.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
@HiltViewModel
class SplashViewModel @Inject constructor(): BaseViewModel(){

    private val _navigationEvent = MutableSharedFlow<SplashEvent>()
    val navigationEvent: Flow<SplashEvent> get() = _navigationEvent

    init {
        startSplash()
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal fun startSplash() {
        viewModelScope.launch {
            delay(SPLASH_TIME_MILLIS)
            _navigationEvent.emit(SplashEvent.NavigateToHome)
        }
    }

    companion object {
        const val SPLASH_TIME_MILLIS = 2 * 1000L
    }
}

sealed class SplashEvent  {
    object Initial : SplashEvent()
    object NavigateToHome : SplashEvent()
}