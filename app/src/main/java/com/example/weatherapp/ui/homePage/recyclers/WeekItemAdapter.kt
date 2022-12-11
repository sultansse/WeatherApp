package com.example.weatherapp.ui.homePage.recyclers


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import kotlinx.android.synthetic.main.item_week_details.view.*


class WeekItemAdapter :
    ListAdapter<WeekItem, WeekItemAdapter.ItemViewHolder>(RowItemDiffCallbackWeek()) {


    class ItemViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val dayOfWeek: TextView = row.findViewById(R.id.day_of_week_textview)
        val img: ImageView = row.findViewById(R.id.weather_icon_per_hour_imageview)
        val dayTempOfDayWeek: TextView = row.findViewById(R.id.daytime_temperature_week_textview)
        val nightTempOfDayWeek: TextView =
            row.findViewById(R.id.nighttime_temperature_week_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_week_details, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        val context = holder.dayOfWeek.context

        holder.dayOfWeek.text =
            context.resources.getString(item.dayOfWeek)
        holder.dayTempOfDayWeek.text = context.resources.getString(item.dayTempOfDayWeek)
        holder.nightTempOfDayWeek.text = context.resources.getString(item.nightTempOfDayWeek)
        holder.img.setImageResource(R.drawable.cloudy)         // need change img not by temperature, but by weather
        //listener to go detailed fragment
        holder.itemView.itemWeekDetails.setOnClickListener() {
//            Navigation.findNavController(view).navigate(R.id.action_to_weekDetails)
            Navigation.findNavController(holder.itemView).navigate(R.id.action_to_weekDetails)
        }
    }
}


