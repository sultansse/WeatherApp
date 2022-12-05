package com.example.weatherapp.viewModel.searchPage.recyclers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import kotlinx.android.synthetic.main.item_week_details.view.*
import kotlinx.android.synthetic.main.search_items.view.*

class SearchItemAdapter :
    ListAdapter<ItemCity, SearchItemAdapter.ItemViewHolder>(RowItemDiffCallbackCity()) {

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
        val item = getItem(position)
        holder.name.text = item.name
        holder.desc.text = item.desc
        holder.img.setImageResource(item.image)

        holder.itemView.constraint.setOnClickListener() {
            Log.d("SearchItemAdapter", "onBindViewHolder: navigate listener ")
            Navigation.findNavController(holder.itemView).navigate(R.id.action_to_detailedCityFragment)
        }
    }


//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val charSearch = constraint.toString()
//                if (charSearch.isEmpty()) {
//                    dataset = countryList
//                } else {
//                    val resultList = ArrayList<String>()
//                    for (row in countryList) {
//                        if (row.lowercase(Locale.ROOT)
//                                .contains(charSearch.lowercase(Locale.ROOT))
//                        ) {
//                            resultList.add(row)
//                        }
//                    }
//                    dataset = resultList
//                }
//                val filterResults = FilterResults()
//                filterResults.values = dataset
//                return filterResults
//            }
//
//            @Suppress("UNCHECKED_CAST")
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                dataset = results?.values as ArrayList<String>
//                notifyDataSetChanged()
//            }
//
//        }
//    }

}

