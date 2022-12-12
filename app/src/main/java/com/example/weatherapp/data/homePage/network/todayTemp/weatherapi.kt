package com.example.weatherapp.data.homePage.network.todayTemp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface weatherapi {
    @GET("weather")
    fun getweather(
        @Query("q") cityname: String?,
        @Query("appid") apikey: String?
    ): Call<Example?>?
}
