package com.example.weatherapp.ui.homePage

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.homePage.network.todayTemp.Example
import com.example.weatherapp.data.homePage.network.todayTemp.Main
import com.example.weatherapp.data.homePage.network.todayTemp.NetworkData
import com.example.weatherapp.data.homePage.network.todayTemp.weatherapi
import com.example.weatherapp.data.repository.Repository
import com.example.weatherapp.ui.homePage.recyclers.TodayItem
import com.example.weatherapp.ui.homePage.recyclers.WeekItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomePageViewModel/*(
    val database: TodayDatabaseDao,
    application: Application
)*/ : ViewModel()/*AndroidViewModel(application)*/ {

    private var _todayDataset: MutableLiveData<List<TodayItem>> = /*database.getAllTodays() todo*/
        MutableLiveData()
    val todayDataset: MutableLiveData<List<TodayItem>> get() = _todayDataset

    private var _weekDataset: MutableLiveData<List<WeekItem>> = MutableLiveData()
    val weekDataset: LiveData<List<WeekItem>> get() = _weekDataset

    private val network = NetworkData.getInstance()
    private val repository = Repository.getInstance()

//    var _temperature:String? = null

    //    val temperature = combine(
////        repository.temperatureToday,
//        temperature,
//        repository.currentTemperatureType
//    ) { temperature, type ->
//        "$temperature${type.toFormattedString()}"
//    }.asLiveData()
    private var _temperature: MutableLiveData<String?> = MutableLiveData()
    val temperature: MutableLiveData<String?> get() = _temperature


    init {
        loadRecyclerData()
    }

    private fun loadRecyclerData() {
        val itemsToday = repository.todayRecyclerData
        _todayDataset.value = itemsToday
        val itemsWeek = repository.weekRecyclerData
        _weekDataset.value = itemsWeek
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun getweather(v: View?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val myapi: weatherapi = retrofit.create(weatherapi::class.java)
        val examplecall: Call<Example?>? =
            myapi.getweather(/*et.getText().toString()*/"Kaskelen".trim { it <= ' ' },
                network.apikey
            )

        examplecall?.enqueue(object : Callback<Example?> {
            override fun onResponse(call: Call<Example?>, response: Response<Example?>) {
                if (response.code() == 404) {
//                    Toast.makeText(
//                        this@MainActivity,
//                        "Please Enter a valid City",
//                        Toast.LENGTH_LONG
//                    ).show()
                } else if (!response.isSuccessful) {
//                    Toast.makeText(
//                        this@MainActivity,
//                        response.code().toString() + " ",
//                        Toast.LENGTH_LONG
//                    ).show()
                    return
                }
                val mydata: Example? = response.body()
                val main: Main = mydata?.getMain()!!
                val temp: Double = main.temp!!
                _temperature.value = (temp - 273.15).toInt().toString() + "C"
//                et.setText(temperature.toString())
            }

            override fun onFailure(call: Call<Example?>, t: Throwable) {
//                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}