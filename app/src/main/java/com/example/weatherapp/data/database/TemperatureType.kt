package com.example.weatherapp.data.database

enum class TemperatureType {
    Celcius, Faranheit;

    fun toFormattedString() = when (this) {
        Celcius -> "°C"
        Faranheit -> "°F"
    }
}