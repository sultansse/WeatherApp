package com.example.weatherapp.repository

import com.example.weatherapp.R
import com.example.weatherapp.repository.model.TemperatureType
import com.example.weatherapp.viewModel.NewsPage.recycler.RecyclerItem
import com.example.weatherapp.viewModel.homePage.recyclers.TodayItem
import com.example.weatherapp.viewModel.homePage.recyclers.WeekItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class Repository private constructor(){
    // by default
    private val _currentTemperatureType = MutableStateFlow<TemperatureType>(TemperatureType.Celcius)
    val currentTemperatureType: Flow<TemperatureType> = _currentTemperatureType

    private val _temperatureToday = MutableStateFlow<Int>(28)
    val temperatureToday: Flow<Int> = _temperatureToday

    fun toggleTemperatureType() {
        val newType = when (_currentTemperatureType.value) {
            TemperatureType.Celcius -> TemperatureType.Faranheit
            TemperatureType.Faranheit -> TemperatureType.Celcius
        }
        _currentTemperatureType.value = newType
    }

    companion object {
        private var INSTANCE: Repository? = null

        fun getInstance(): Repository {
            var instance = INSTANCE
            if (instance == null) {
                instance = Repository()
                INSTANCE = instance
            }
            return instance
        }
    }


val newsRecyclerData = listOf(
    RecyclerItem(
        /*image also*/
        R.string.news_title,
        R.string.news_text,

    ),
    RecyclerItem(
        /*image also*/
        R.string.news_title,
        R.string.news_text,

    ),
    RecyclerItem(
        /*image also*/
        R.string.news_title,
        R.string.news_text,

    ),
    RecyclerItem(
        /*image also*/
        R.string.news_title,
        R.string.news_text,

    ),
    RecyclerItem(
        /*image also*/
        R.string.news_title,
        R.string.news_text,

    ),
    RecyclerItem(
        /*image also*/
        R.string.news_title,
        R.string.news_text,

    )

)


    //  data from API network ==============================
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
            R.string.dayOfWeek,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ),
        WeekItem(
            R.string.dayOfWeek,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        )
    )


}