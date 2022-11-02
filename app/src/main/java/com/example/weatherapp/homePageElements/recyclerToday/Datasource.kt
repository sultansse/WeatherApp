package com.example.weatherapp.homePageElements.recyclerToday;

import com.example.weatherapp.R

class Datasource {

    fun loadViews(): MutableList<Affirmation> {
        val res = mutableListOf<Affirmation>()
        res.addAll(
            listOf(
                Affirmation(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                ),
                Affirmation(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                ),
                Affirmation(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                ),
                Affirmation(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                ),
                Affirmation(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                ),
                Affirmation(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                ),
                Affirmation(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                )
            )
        )
        return res
    }

}