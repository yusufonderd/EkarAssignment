package com.ekar.assignment.ui

import androidx.annotation.StringRes
import com.ekar.assignment.R

/**
 * @author yusuf.onder
 * Created on 3.01.2022
 */
sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Splash : Screen("splash", R.string.splash)
    object Map : Screen("map", R.string.map)
    object Vehicle : Screen("vehicle", R.string.vehicle)
}