package com.example.weatherapp.viewModel.homePage.recyclers


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import kotlinx.android.synthetic.main.item_week_details.view.*
import kotlinx.coroutines.flow.callbackFlow


class WeekItemAdapter(
    private val weekDataset: MutableList<WeekItem>,
    private val view: View

) : RecyclerView.Adapter<WeekItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val dayOfWeek: TextView = view.findViewById(R.id.day_of_week_textview)
        val dayTempOfDayWeek: TextView = view.findViewById(R.id.daytime_temperature_week_textview)
        val nightTempOfDayWeek: TextView =
            view.findViewById(R.id.nighttime_temperature_week_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_week_details, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = weekDataset[position]
        val context = holder.dayOfWeek.context

        holder.dayOfWeek.text = context.resources.getString(item.dayOfWeek)
        holder.dayTempOfDayWeek.text = context.resources.getString(item.dayTempOfDayWeek)
        holder.nightTempOfDayWeek.text = context.resources.getString(item.nightTempOfDayWeek)

        //listener to go detailed fragment
        holder.itemView.itemWeekDetails.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.action_to_weekDetails)
        }

        callbackFlow<WeekItemAdapter> {
            Navigation.findNavController(view).navigate(R.id.action_to_homeFragment)
        }

    }


    override fun getItemCount() = weekDataset.size
}