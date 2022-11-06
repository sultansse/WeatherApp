package com.example.weatherapp.viewModel.homePage

import androidx.lifecycle.ViewModel
import com.example.weatherapp.repository.Repository

class HomePageViewModel : ViewModel() {

    fun todayTemperature() : String{

        val temperature: Int = Repository().temperatureToday
        val format:String = Repository().formatOfTemperature

        val res: String by lazy {
            "$temperature$format"
        }
        return res
    }




//    fun createTodayRecycler(view: View){
//        val todayDataset = DatasourceRecyclers().loadTodayViews()
//        val todayRecyclerview = view.findViewById<RecyclerView>(R.id.todayDetailsRecycler)
//        todayRecyclerview.adapter = TodayItemAdapter(this, todayDataset)
//        todayRecyclerview.setHasFixedSize(true)
//    }
//    fun createWeekRecycler(view: View){
//        val weekDataset = DatasourceRecyclers().loadWeekViews()
//        val weekRecyclerview = view.findViewById<RecyclerView>(R.id.weekDaysDetailsRecycler)
//        weekRecyclerview.adapter = WeekItemAdapter(this, weekDataset)
//        weekRecyclerview.setHasFixedSize(true)
//    }

}