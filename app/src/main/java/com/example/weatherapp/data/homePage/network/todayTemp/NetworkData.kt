package com.example.weatherapp.data.homePage.network.todayTemp

import android.location.LocationListener
import android.location.LocationManager

class NetworkData {
    var apikey = "bb4850d53c0fdb94e9d1595a60172c24"
    var url = "api.openweathermap.org/data/2.5/weather?q=kaskelen&appid=$apikey"
    var manager: LocationManager? = null
    var locationListener: LocationListener? = null


    companion object {
        private var INSTANCE: NetworkData? = null

        fun getInstance(): NetworkData {
            var instance = INSTANCE
            if (instance == null) {
                instance = NetworkData()
                INSTANCE = instance
            }
            return instance
        }
    }
}