package com.example.weatherapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.homePageElements.recyclerToday.Datasource
import com.example.weatherapp.homePageElements.recyclerToday.ItemAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myDataset = Datasource().loadViews()
        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.todayDetailsRecycler)
        recyclerView?.adapter = ItemAdapter(this, myDataset)
//        recyclerView?.setHasFixedSize(true)
    }

}