package com.example.ec2_solorzano_diego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ec2_solorzano_diego.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapBinding
    private lateinit var googleMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentMap = supportFragmentManager.findFragmentById(R.id.fcv_map) as SupportMapFragment
        fragmentMap.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        val idatNorteLocation = LatLng(-12.011431733774602, -77.07125323228064)
        val homeLocation = LatLng(-12.024625693446243, -77.06569873413235)
        val plazaNorteLocation = LatLng(-12.006835703436812, -77.05987160495036)
        googleMap.addMarker(MarkerOptions().position(idatNorteLocation).title("Idat TOMAS VALLE"))
        googleMap.addMarker(MarkerOptions().position(homeLocation).title("Hogar - Los Lirios"))
        googleMap.addMarker(MarkerOptions().position(plazaNorteLocation).title("Plaza Norte"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(idatNorteLocation, 16f))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLocation, 16f))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(plazaNorteLocation, 16f))

    }
}