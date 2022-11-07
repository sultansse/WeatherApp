package com.example.weatherapp.repository.model

enum class TemperatureType {
    Celcius, Faranheit;

    fun toFormattedString() = when (this) {
        TemperatureType.Celcius -> "°C"
        TemperatureType.Faranheit -> "°F"
    }
}