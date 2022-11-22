package com.example.weatherapp.viewModel.newsPage

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.repository.Repository
import com.example.weatherapp.viewModel.newsPage.recycler.DatasourceNews
import com.example.weatherapp.viewModel.newsPage.recycler.NewsItemAdapter
import com.example.weatherapp.viewModel.newsPage.recycler.RecyclerItem

class NewsPageViewModel : ViewModel() {

    private val repository = Repository.getInstance()

    fun loadRecyclerview(view: View, tabName: String) {

        var verticalNews: MutableList<RecyclerItem>? = null

        when (tabName) {
            "top" -> verticalNews = DatasourceNews().loadTopNews()
            "daily" -> verticalNews = DatasourceNews().loadDailyNews()
            "other" -> verticalNews = DatasourceNews().loadOtherNews()
        }

        //need use diffUtil
        //observe that data changed and relocate below lines to Fragment class
        val newsRecyclerview = view.findViewById<RecyclerView>(R.id.newsRecyclerView)
        newsRecyclerview.adapter = NewsItemAdapter(verticalNews!!)
    }

}