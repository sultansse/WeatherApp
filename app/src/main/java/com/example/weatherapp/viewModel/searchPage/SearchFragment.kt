package com.example.weatherapp.viewModel.searchPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentSearchBinding
import com.example.weatherapp.viewModel.searchPage.activities.City1Activity
import com.example.weatherapp.viewModel.searchPage.activities.City2Activity
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemsAdapter
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemsModal
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(), ItemsAdapter.ClickListener {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    val viewModel: SearchPageViewModel by viewModels()


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
            ItemsModal("Almaty", "Alma-Ata, Almaty (until 1921 - Verny) - the former capital of the Republic of Kazakhstan", R.drawable.almaty),
            ItemsModal("Aktobe", "Aktobe (until 1999 Aktobe) is a city in Western Kazakhstan, the administrative center of the Aktobe region", R.drawable.aktobe),
            ItemsModal("Karaganda", "Karaganda is a city in Kazakhstan, the administrative center of the Karaganda region", R.drawable.karaganda),
            ItemsModal("Shymkent", "Shymkent (a city in the south of Kazakhstan, one of the three cities of the country)", R.drawable.shymkent),
            ItemsModal("Taraz", "Taraz (formerly Zhambyl) is the administrative center of Zhambyl Province in Kazakhstan.", R.drawable.taraz),
            ItemsModal("Pavlodar", "Pavlodar is a city located in northeastern Kazakhstan, 450 km northeast of the capital Astana", R.drawable.pavlodar),
            ItemsModal("Ust-Kamenogorsk", "Ust-Kamenogorsk (Kazakh: Öskemen Sound) is the largest city in eastern Kazakhstan", R.drawable.oskemen),
            ItemsModal("Semey", "Semey (until 2007 - Semipalatinsk) is a city in eastern Kazakhstanlocated on both banks of the Irtysh River", R.drawable.semey),
            ItemsModal("Atyrau", "Atyrau (until 1991 - Guryev) is a city in Kazakhstan, the administrative center of Atyrau Region", R.drawable.atyrau),
            ItemsModal("Kyzylorda", "Kyzylorda (formerly Kamysty, Ak-Mechet, Perovsk, Kzyl-Orda) is a city in Kazakhstan", R.drawable.kyzylorda),
            ItemsModal("Kostanay", "Kostanay (formerly - Nikolaevsk, Kostanay - a city in Kazakhstan, the administrative center of Kostanay region", R.drawable.kostanay),
            ItemsModal("Uralsk", "Uralsk or Oral (until 1775 - Yaitsky town) is a city in the European part of Kazakhstan", R.drawable.oral),
            ItemsModal("Petropavlovsk", "Petropavlovsk is a city in northern Kazakhstan, the administrative center of the NKR", R.drawable.petropavl),
            ItemsModal("Aktau", "Aktau (Kazakh: Sound Aktau, Aqtau; White Mountain) is a port city in the south-west of Kazakhstan", R.drawable.aktau),
            ItemsModal("Turkestan", "Turkestan is a city in southern Kazakhstan, near the Syr Darya River", R.drawable.turkistan),
            ItemsModal("Temirtau", "Temirtau (Kazakh: Теміртау) is a city in Kazakhstan, located in the Karaganda Region", R.drawable.temirtau),
            ItemsModal("Kokshetau", "Kokshetau (until 1993 - Kokchetav) is a city in Kazakhstan, since 1999", R.drawable.kokshetau),
            ItemsModal("Taldykorgan", "Taldykorgan (until 1993 - Taldy-Kurgan, until 1920 - Gavrilovka) is a city in the south-east", R.drawable.taldykorgan),
            ItemsModal("Ekibastuz", "Ekibastuz is a city of regional subordination in the west of the Pavlodar region of Kazakhstan", R.drawable.ekibastuz),
            ItemsModal("Rudnyi", "A city on the Tobol River in the Kostanay region of Kazakhstan", R.drawable.rudnyi)
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





















