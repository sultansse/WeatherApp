package com.example.weatherapp.viewModel.searchPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentHomeBinding
import com.example.weatherapp.databinding.FragmentSearchBinding
import com.example.weatherapp.viewModel.homePage.HomePageViewModel
import com.example.weatherapp.viewModel.searchPage.activities.City1Activity
import com.example.weatherapp.viewModel.searchPage.activities.City2Activity
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemsAdapter
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemsModal
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(), ItemsAdapter.ClickListener {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    val viewModel: HomePageViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemsAdapter = ItemsAdapter(this);
        itemsAdapter.submitList(allCities)
        recyclerViewSearch.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewSearch.setHasFixedSize(true)
        recyclerViewSearch.adapter = itemsAdapter


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = allCities.filter { it.name.contains(newText ?: "", ignoreCase = false) }
                itemsAdapter.submitList(filteredList)
                return true
            }

        })
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

    companion object {
        private val allCities = listOf(
            ItemsModal("Astana", "Astana (earlier - Akmolinsk, Tselinograd, Akmola, Nur-Sultan) - the capital of the Republic of Kazakhstan", R.drawable.astana),
            ItemsModal("Aktobe", "Aktobe (until 1999 Aktobe) is a city in Western Kazakhstan, the administrative center of the Aktobe region", R.drawable.aktobe),
            ItemsModal("Karaganda", "Karaganda is a city in Kazakhstan, the administrative center of the Karaganda region", R.drawable.karaganda),
            ItemsModal("Almaty", "Alma-Ata, Almaty (Almaty until 1921 - Verny) - a city of republican significance in Kazakhstan", R.drawable.almaty),
            ItemsModal("Astana", "Astana (earlier - Akmolinsk, Tselinograd, Akmola, Nur-Sultan) - the capital of the Republic of Kazakhstan", R.drawable.astana),
            ItemsModal("Aktobe", "Aktobe (until 1999 Aktobe) is a city in Western Kazakhstan, the administrative center of the Aktobe region", R.drawable.aktobe),
            ItemsModal("Karaganda", "Karaganda is a city in Kazakhstan, the administrative center of the Karaganda region", R.drawable.karaganda),
            ItemsModal("Almaty", "Alma-Ata, Almaty (Almaty until 1921 - Verny) - a city of republican significance in Kazakhstan", R.drawable.almaty)
        )
    }

/*
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.bottom_nav_menu, menu)


    }
*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}





















