package com.example.weatherapp.viewModel.searchPage.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R

class SearchItemAdapter(
    private val view: View,
    private var dataset: MutableList<ItemCity>
) : RecyclerView.Adapter<SearchItemAdapter.ItemViewHolder>() {

//    val searchFilter: SearchFilter = SearchFilter()

//    @SuppressLint("NotifyDataSetChanged")
//    fun filter(filterList: MutableList<ItemCity>) {
//        dataset = filterList
//        notifyDataSetChanged()
//    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.RecycleItemImage)
        val name: TextView = view.findViewById(R.id.RecycleItemName)
        val desc: TextView = view.findViewById(R.id.RecycleItemDesc)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.search_items, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.name.text = item.name
        holder.desc.text = item.desc
        holder.img.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}