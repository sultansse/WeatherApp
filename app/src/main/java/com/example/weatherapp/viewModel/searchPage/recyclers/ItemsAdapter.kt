package com.example.weatherapp.viewModel.searchPage.recyclers

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.City1Activity
import com.example.weatherapp.R
import com.example.weatherapp.viewModel.searchPage.SearchFragment
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemsAdapter.ItemsAdapterVH
import kotlinx.android.synthetic.main.search_items.view.*

class ItemsAdapter
    (var clickListener: ClickListener)
    : RecyclerView.Adapter<ItemsAdapterVH>() {

   var itemsModalList = ArrayList<ItemsModal>();
    fun setData(itemsModalList: ArrayList<ItemsModal>){
      this.itemsModalList = itemsModalList;
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        return ItemsAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.search_items, parent, false ))
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {
        val itemsModal = itemsModalList[position];
        holder.name.text = itemsModal.name
        holder.desc.text = itemsModal.desc
        holder.image.setImageResource(itemsModal.image)

        holder.itemView.setOnClickListener{
            clickListener.ClickedItem(itemsModal)
        }
    }

    override fun getItemCount(): Int {
        return itemsModalList.size
    }

    class ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.cityName
        val desc = itemView.cityInfo
        val image = itemView.SearchImageView
    }

    interface ClickListener{
        fun ClickedItem(itemsModal: ItemsModal)
    }
}