package com.example.weatherapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel: ViewModel(){
    var number = 0

    val currentNumber: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

}