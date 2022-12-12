package com.example.weatherapp.data.homePage.network.todayTemp

import com.google.gson.annotations.SerializedName

internal class Example {

    @SerializedName("main")
    private var main: Main? = null

    fun getMain(): Main? {
        return main
    }

    fun setMain(main: Main?) {
        this.main = main
    }
}