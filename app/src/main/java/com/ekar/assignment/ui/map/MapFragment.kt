package com.ekar.assignment.ui.map

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.ekar.assignment.R
import com.ekar.assignment.databinding.FragmentMapBinding
import com.ekar.assignment.ui.cardetail.VehicleFragment
import com.ekar.assignment.utils.DummyLocationProvider

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.yemeksepeti.yemekcom.ui.viewBinding
import dagger.hilt.android.AndroidEntryPoint

const val PADDING_MAP = 100

@AndroidEntryPoint
class MapFragment : Fragment(R.layout.fragment_map), GoogleMap.OnMarkerClickListener,
    GoogleMap.OnMapClickListener {

    private val binding by viewBinding(FragmentMapBinding::bind)

    lateinit var googleMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMap()
    }

    private fun initMap() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync {
            this.googleMap = it
            placeMarkers()
            googleMap.setOnMarkerClickListener(this)
            googleMap.setOnMapClickListener(this)
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

    override fun onMapClick(latLng: LatLng) {
        val fragment = parentFragmentManager.findFragmentByTag(VehicleFragment.TAG)
        if (fragment != null) {
            parentFragmentManager.beginTransaction().remove(fragment).commit()
        }
    }

}