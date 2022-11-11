package com.example.weatherapp.viewModel.newsPage.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R

class ItemAdapter(
    private val dataset: MutableList<RecyclerItem>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.news_title)
        val text: TextView = view.findViewById(R.id.news_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        val context = holder.title.context
        holder.title.text = context.resources.getString(item.title)
        holder.text.text = context.resources.getString(item.text)
    }

    override fun getItemCount(): Int = dataset.size

}

data class NewsType(
    val title: TextView,
    val text: TextView
)