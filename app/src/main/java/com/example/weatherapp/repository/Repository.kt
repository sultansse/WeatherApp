package com.example.weatherapp.repository

import com.example.weatherapp.R
import com.example.weatherapp.viewModel.homePage.recyclers.TodayItem
import com.example.weatherapp.viewModel.homePage.recyclers.WeekItem

class Repository {

/*
// add some this kind of validator
    fun hasInternet(): Boolean{
        val late init res
        if (!user.hasInternetConnection){
            res = false
            println("u don't have connection")
//        take data from DB
        }else{
            res = true
//        take data from WebServices
        }
        return res
    }
*/

    val todayRecyclerData = listOf(
        TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        ),
        TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        ),
        TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        ),
        TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        ),
        TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        ),
        TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        ),
        TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        )
    )

    val weekRecyclerData = listOf(
        WeekItem(
            R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,/*R.id.weatherIconPerHour,*/
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        )
    )


}