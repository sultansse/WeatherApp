package com.example.weatherapp.viewModel.NewsPage.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.viewModel.homePage.recyclers.TodayItemAdapter
import com.example.weatherapp.viewModel.newsPage.NewsFragment

class ItemAdapter (
    private val context: NewsFragment
) : ListAdapter<RecyclerItem, ItemAdapter.ItemViewHolder>(diffUtilCallback) {


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.news_header1)
        //        val weatherIconPerHour: ImageView = view.findViewById(R.id.weatherIconPerHour)
        val text: TextView = view.findViewById(R.id.news_subtitle)
//        val title_hor: TextView = view.findViewById(R.id.)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.top_news, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)

        //todo troubles with homeFragment migrating to HomePageViewModel
        holder.title.text = context.resources.getString(item.title)
//        holder.weatherIconPerHour.setImageResource(item.weatherIconPerHour)
        holder.text.text = context.resources.getString(item.text)
    }

}

val diffUtilCallback = object : DiffUtil.ItemCallback<RecyclerItem>() {
    override fun areItemsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem): Boolean {
        return oldItem == newItem
    }
}