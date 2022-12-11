package com.example.weatherapp.data.repository

import com.example.weatherapp.R
import com.example.weatherapp.data.database.TemperatureType
import com.example.weatherapp.ui.homePage.recyclers.TodayItem
import com.example.weatherapp.ui.homePage.recyclers.WeekItem
import com.example.weatherapp.ui.newsPage.recycler.RecyclerItem
import com.example.weatherapp.ui.searchPage.recyclers.ItemCity
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
        ),
        ItemCity(
            "Aktobe",
            "Aktobe (until 1999 Aktobe) is a city in Western Kazakhstan, the administrative center of the Aktobe region",
            R.drawable.aktobe
        ),
        ItemCity(
            "Karaganda",
            "Karaganda is a city in Kazakhstan, the administrative center of the Karaganda region",
            R.drawable.karaganda
        ),
        ItemCity(
            "Almaty",
            "Alma-Ata, Almaty (Almaty until 1921 - Verny) - a city of republican significance in Kazakhstan",
            R.drawable.almaty
        ),
        ItemCity(
            "Shymkent",
            "Shymkent (a city in the south of Kazakhstan, one of the three cities of the country",
            R.drawable.shymkent
        ),
        ItemCity(
            "Taraz",
            "Taraz (formerly Zhambyl) is the administrative center of Zhambyl Province in Kazakhstan",
            R.drawable.taraz
        ),
        ItemCity(
            "Pavlodar",
            "Pavlodar is a city located in northeastern Kazakhstan, 450 km northeast of the capital Astana",
            R.drawable.pavlodar
        ),
        ItemCity(
            "Ust-Kamenogorsk",
            "Ust-Kamenogorsk (Kazakh: Öskemen Sound) is the largest city in eastern Kazakhstan",
            R.drawable.oskemen
        ),
        ItemCity(
            "Semey",
            "Semey (until 2007 - Semipalatinsk) is a city in eastern Kazakhstanlocated on both banks of the Irtysh River",
            R.drawable.semey
        ),
        ItemCity(
            "Atyrau",
            "Atyrau (until 1991 - Guryev) is a city in Kazakhstan, the administrative center of Atyrau Region",
            R.drawable.atyrau
        ),
        ItemCity(
            "Kyzylorda",
            "Kyzylorda (formerly Kamysty, Ak-Mechet, Perovsk, Kzyl-Orda) is a city in Kazakhstan",
            R.drawable.kyzylorda
        ),
        ItemCity(
            "Kostanay",
            "Kostanay (formerly - Nikolaevsk, Kostanay - a city in Kazakhstan, the administrative center of Kostanay region",
            R.drawable.kostanay
        ),
        ItemCity(
            "Uralsk",
            "Uralsk or Oral (until 1775 - Yaitsky town) is a city in the European part of Kazakhstan",
            R.drawable.oral
        ),
        ItemCity(
            "Petropavlovsk",
            "Petropavlovsk is a city in northern Kazakhstan, the administrative center of the NKR",
            R.drawable.pavlodar
        ),
        ItemCity(
            "Aktau",
            "Aktau (Kazakh: Sound Aktau, Aqtau; White Mountain) is a port city in the south-west of Kazakhstan",
            R.drawable.aktau
        ),
        ItemCity(
            "Turkestan",
            "Turkestan is a city in southern Kazakhstan, near the Syr Darya River",
            R.drawable.turkistan
        ),
        ItemCity(
            "Temirtau",
            "Temirtau (Kazakh: Теміртау) is a city in Kazakhstan, located in the Karaganda Region",
            R.drawable.temirtau
        ),
        ItemCity(
            "Kokshetau",
            "Kokshetau (until 1993 - Kokchetav) is a city in Kazakhstan, since 1999",
            R.drawable.kokshetau
        ),
        ItemCity(
            "Taldykorgan",
            "Taldykorgan (until 1993 - Taldy-Kurgan, until 1920 - Gavrilovka) is a city in the south-east",
            R.drawable.taldykorgan
        ),
        ItemCity(
            "Ekibastuz",
            "Ekibastuz is a city of regional subordination in the west of the Pavlodar region of Kazakhstan",
            R.drawable.ekibastuz
        ),
        ItemCity(
            "Rudnyi",
            "A city on the Tobol River in the Kostanay region of Kazakhstan",
            R.drawable.rudnyi
        ),

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