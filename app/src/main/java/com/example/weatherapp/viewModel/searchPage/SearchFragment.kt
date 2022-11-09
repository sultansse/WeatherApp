package com.example.weatherapp.viewModel.searchPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.City1Activity
import com.example.weatherapp.City2Activity
import com.example.weatherapp.R
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemsAdapter
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemsModal
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.Locale.filter

class SearchFragment : Fragment(), ItemsAdapter.ClickListener {

    val imageName = arrayOf(
        ItemsModal("Astana", "Astana (earlier - Akmolinsk, Tselinograd, Akmola, Nur-Sultan) - the capital of the Republic of Kazakhstan", R.drawable.astana),
        ItemsModal("Aktobe", "Aktobe (until 1999 Aktobe) is a city in Western Kazakhstan, the administrative center of the Aktobe region", R.drawable.aktobe),
        ItemsModal("Karaganda", "Karaganda is a city in Kazakhstan, the administrative center of the Karaganda region", R.drawable.karaganda),
        ItemsModal("Almaty", "Alma-Ata, Almaty (Almaty until 1921 - Verny) - a city of republican significance in Kazakhstan", R.drawable.almaty),
        ItemsModal("Astana", "Astana (earlier - Akmolinsk, Tselinograd, Akmola, Nur-Sultan) - the capital of the Republic of Kazakhstan", R.drawable.astana),
        ItemsModal("Aktobe", "Aktobe (until 1999 Aktobe) is a city in Western Kazakhstan, the administrative center of the Aktobe region", R.drawable.aktobe),
        ItemsModal("Karaganda", "Karaganda is a city in Kazakhstan, the administrative center of the Karaganda region", R.drawable.karaganda),
        ItemsModal("Almaty", "Alma-Ata, Almaty (Almaty until 1921 - Verny) - a city of republican significance in Kazakhstan", R.drawable.almaty)
    )

    val itemsModalList = ArrayList<ItemsModal>()
    var itemsAdapter : ItemsAdapter? = null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (items in imageName) {
            itemsModalList.add(items)
        }
        itemsAdapter = ItemsAdapter(this);
        itemsAdapter!!.setData(itemsModalList)
        recyclerViewSearch.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewSearch.setHasFixedSize(true)
        recyclerViewSearch.adapter = itemsAdapter
    }

    override fun ClickedItem(itemsModal: ItemsModal) {
        Log.e("TAG", itemsModal.name)
        when(itemsModal.name){
            "Astana" ->
                startActivity(Intent(requireContext(), City1Activity::class.java))
            "Aktobe" ->
                startActivity(Intent(requireContext(), City2Activity::class.java))
         else -> {
             Toast.makeText(requireContext(), "No Action",  Toast.LENGTH_LONG).show()
         }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.bottom_nav_menu, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })

    }
}





















