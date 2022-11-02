package com.example.weatherapp.homePageElements.recyclers;

import com.example.weatherapp.R

class Datasource {

    fun loadTodayViews(): MutableList<TodayItem> {
        val res = mutableListOf<TodayItem>()
        res.addAll(
            listOf(
                TodayItem(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                ),
                TodayItem(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                ),
                TodayItem(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                ),
                TodayItem(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                ),
                TodayItem(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                ),
                TodayItem(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                ),
                TodayItem(
                    R.string.temperature_per_hour,
//                    R.id.weatherIconPerHour,
                    R.string.each_time_today
                )
            )
        )
        return res
    }

    fun loadWeekViews(): MutableList<WeekItem> {
        val res = mutableListOf<WeekItem>()
        res.addAll(
            listOf(
                WeekItem(R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/R.string.dayTempOfDayWeek,R.string.nightTempOfDayWeek),
                WeekItem(R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/R.string.dayTempOfDayWeek,R.string.nightTempOfDayWeek),
                WeekItem(R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/R.string.dayTempOfDayWeek,R.string.nightTempOfDayWeek),
                WeekItem(R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/R.string.dayTempOfDayWeek,R.string.nightTempOfDayWeek),
                WeekItem(R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/R.string.dayTempOfDayWeek,R.string.nightTempOfDayWeek),
                WeekItem(R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/R.string.dayTempOfDayWeek,R.string.nightTempOfDayWeek)
            )
        )
        return res
    }

}