package com.example.weatherapp.repository

import com.example.weatherapp.R
import com.example.weatherapp.repository.model.TemperatureType
import com.example.weatherapp.viewModel.homePage.recyclers.TodayItem
import com.example.weatherapp.viewModel.homePage.recyclers.WeekItem
import com.example.weatherapp.viewModel.newsPage.recycler.RecyclerItem
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemCity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class Repository private constructor() {
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

    // search page data =============================================
    val allCities = listOf(
        ItemCity(
            "Astana",
            "Astana (earlier - Akmolinsk, Tselinograd, Akmola, Nur-Sultan) - the capital of the Republic of Kazakhstan",
            R.drawable.astana
        ), ItemCity(
            "Aktobe",
            "Aktobe (until 1999 Aktobe) is a city in Western Kazakhstan, the administrative center of the Aktobe region",
            R.drawable.aktobe
        ), ItemCity(
            "Karaganda",
            "Karaganda is a city in Kazakhstan, the administrative center of the Karaganda region",
            R.drawable.karaganda
        ), ItemCity(
            "Almaty",
            "Alma-Ata, Almaty (Almaty until 1921 - Verny) - a city of republican significance in Kazakhstan",
            R.drawable.almaty
        ), ItemCity(
            "Astana",
            "Astana (earlier - Akmolinsk, Tselinograd, Akmola, Nur-Sultan) - the capital of the Republic of Kazakhstan",
            R.drawable.astana
        ), ItemCity(
            "Aktobe",
            "Aktobe (until 1999 Aktobe) is a city in Western Kazakhstan, the administrative center of the Aktobe region",
            R.drawable.aktobe
        ), ItemCity(
            "Karaganda",
            "Karaganda is a city in Kazakhstan, the administrative center of the Karaganda region",
            R.drawable.karaganda
        ), ItemCity(
            "Almaty",
            "Alma-Ata, Almaty (Almaty until 1921 - Verny) - a city of republican significance in Kazakhstan",
            R.drawable.almaty
        )
    )


    // news page data =============================================
    val topNewsRecyclerData = listOf(
        RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            )

    )


    val dailyNewsRecyclerData = listOf(
        RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            )

    )
    val otherNewsRecyclerData = listOf(
        RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            ), RecyclerItem(
            /*image also*/
            R.string.news_title,
            R.string.news_text,

            )

    )


    // home page data =============================================
    val todayRecyclerData = listOf(
        TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        ), TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        ), TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        ), TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        ), TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        ), TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        ), TodayItem(
            R.string.temperature_per_hour,/*R.id.weatherIconPerHour,*/
            R.string.each_time_today
        )
    )

    val weekRecyclerData = listOf(
        WeekItem(
            R.string.dayOfWeek,
            R.drawable.cloudy,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ), WeekItem(
            R.string.dayOfWeek,
            R.drawable.cloudy,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ), WeekItem(
            R.string.dayOfWeek,
            R.drawable.cloudy,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ), WeekItem(
            R.string.dayOfWeek,
            R.drawable.sunny,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ), WeekItem(
            R.string.dayOfWeek,
            R.drawable.cloudy,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ), WeekItem(
            R.string.dayOfWeek,
            R.drawable.sunny,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ), WeekItem(
            R.string.dayOfWeek,
            R.drawable.sunny,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ), WeekItem(
            R.string.dayOfWeek,
            R.drawable.cloudy,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ), WeekItem(
            R.string.dayOfWeek,
            R.drawable.sunny,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        ), WeekItem(
            R.string.dayOfWeek,
            R.drawable.cloudy,
            R.string.dayTempOfDayWeek,
            R.string.nightTempOfDayWeek
        )
    )


}