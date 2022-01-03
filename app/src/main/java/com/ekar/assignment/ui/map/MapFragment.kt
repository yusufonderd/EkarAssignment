package com.ekar.assignment.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ekar.assignment.R
import com.ekar.assignment.utils.DummyLocationProvider
import com.ekar.assignment.utils.rememberMapViewWithLifecycle
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.model.*
import com.google.maps.android.ktx.awaitMap
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val PADDING_MAP = 100

@AndroidEntryPoint
class MapFragment : Fragment(), GoogleMap.OnMarkerClickListener {

    lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MainContent()
            }
        }
    }

    @Composable
    fun MainContent() {
        val mapView = rememberMapViewWithLifecycle()
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.White)
        ) {
            AndroidView({ mapView }) { mapView ->
                CoroutineScope(Dispatchers.Main).launch {
                    val map = mapView.awaitMap()
                    this@MapFragment.googleMap = map
                    map.setOnMarkerClickListener(this@MapFragment)
                    placeMarkers()
                }
            }
        }
    }

    private fun placeMarkers() {
        val builder = LatLngBounds.Builder()
        val locationPoints = DummyLocationProvider.locationPoints
        locationPoints.forEach { point ->
            builder.include(point.latLng)
            val markerOptions = MarkerOptions()
                .position(point.latLng)
                .title(point.title)
                .icon(BitmapDescriptorFactory.defaultMarker(point.iconResource))
            googleMap.addMarker(markerOptions)
        }
        val bounds: LatLngBounds = builder.build()
        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, PADDING_MAP))
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        navigateVehicleDetail()
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(marker.position))
        return true
    }

    private fun navigateVehicleDetail() {
        findNavController().navigate(R.id.action_map_to_vehicle)
    }

}