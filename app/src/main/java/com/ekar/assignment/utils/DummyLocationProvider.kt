package com.ekar.assignment.utils

import com.google.android.gms.maps.model.LatLng
import kotlin.random.Random

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
object DummyLocationProvider {
    private val dubaiCenter = LatLng(25.276987, 55.296249)
    var locationPoints: ArrayList<LocationPoint> = arrayListOf()

    private const val HUE_RED = 0.0f
    private const val HUE_ORANGE = 30.0f
    private const val HUE_YELLOW = 60.0f
    private const val HUE_GREEN = 120.0f
    private const val HUE_BLUE = 240.0f
    private val hueColors = listOf(HUE_RED, HUE_ORANGE, HUE_YELLOW, HUE_GREEN, HUE_BLUE)

    init {
        fillLocationPoints()
    }

    private fun fillLocationPoints() {
        repeat(10) {
            locationPoints.add(
                LocationPoint(
                    title = "Dubai Point($it)",
                    latLng = LatLng(
                        dubaiCenter.latitude + Random.nextDouble(0.1),
                        dubaiCenter.longitude + Random.nextDouble(0.1)
                    ),
                    iconResource = hueColors.random()
                )
            )
        }
    }
}

data class LocationPoint(val title: String, val latLng: LatLng, val iconResource: Float)
