package com.example.weatherapp.ui.homePage.recyclers


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R


class TodayItemAdapter :
    ListAdapter<TodayItem, TodayItemAdapter.ItemViewHolder>(RowItemDiffCallbackToday()) {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val temperaturePerHour: TextView = view.findViewById(R.id.time_of_today_textview)
        val img: ImageView = view.findViewById(R.id.weather_icon_per_hour_imageview)
        val eachTimeToday: TextView = view.findViewById(R.id.time_of_today_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_today_details, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        val context = holder.temperaturePerHour.context
        holder.img.setImageResource(R.drawable.sunny)
        holder.temperaturePerHour.text = context.getString(item.tempOfTime)
        holder.eachTimeToday.text = context.getString(item.timeForToday)
    }

}
