package com.example.weatherapp.domain

enum class TemperatureType {
    Celcius, Faranheit;

    fun toFormattedString() = when (this) {
        Celcius -> "°C"
        Faranheit -> "°F"
    }
}