package com.akshat.eCommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.extension.style.layers.addLayer
import com.mapbox.maps.extension.style.layers.generated.RasterLayer
import com.mapbox.maps.extension.style.sources.addSource
import com.mapbox.maps.extension.style.sources.generated.ImageSource

class MapBox : AppCompatActivity() {
    private lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_box)
        mapView = findViewById(R.id.mapView)
        mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS){
            val raster = ImageSource.Builder("id").build()
            raster.url("https://apis.transerve.com/wms/6575a25c1a584227d37bcf70/{z}/{x}/{y}.png")
            it.addSource(raster)
            val rasterLayer = RasterLayer("layer-id", "id")
            it.addLayer(rasterLayer)
        }
    }
}