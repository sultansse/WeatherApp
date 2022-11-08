package com.example.weatherapp.viewModel.searchPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.weatherapp.R

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val search = view.findViewById<SearchView>(R.id.searchView)
        val listView = view.findViewById<ListView>(R.id.listView)
        val names = arrayOf(
            "Абай", "Акколь", "Аксай", "Аксу", "Актау", "Актобе",
            "Алга", "Алматы", "Алтай", "Аральск", "Аркалык", "Арыс",
            "Астана", "Атбасар", "Атырау", "Аягоз", "Байконур",
            "Балхаш", "Булаево", "Державинск", "Ерейментау",
            "Есик", "Есиль", "Жанаозен", "Жанатас", "Жаркент",
            "Жезказган", "Жем", "Жетысай", "Житикара", "Зайсан",
            "Казалинск", "Кандыагаш", "Караганда", "Каражал",
            "Каратау", "Каркаралинск", "Каскелен", "Кентау",
            "Кокшетау", "Конаев", "Костанай", "Косшы", "Кульсары",
            "Курчатов", "Кызылорда", "Ленгер", "Лисаковск", "Макинск",
            "Мамлютка", "Павлодар", "Петропавловск", "Приозёрск", "Риддер",
            "Рудный", "Сарань", "Сарканд", "Сарыагаш", "Сатпаев", "Семей",
            "Сергеевка", "Серебрянск", "Степногорск", "Степняк", "Тайынша",
            "Талгар", "Талдыкорган", "Тараз", "Текели", "Темир", "Темиртау",
            "Тобыл", "Туркестан", "Уральск", "Усть-Каменогорск", "Ушарал",
            "Уштобе", "Форт-Шевченко", "Хромтау", "Шалкар", "Шар", "Шардара",
            "Шахтинск", "Шемонаиха", "Шу", "Шымкент", "Щучинск", "Экибастуз"
        )

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            names
        )
        listView.adapter = adapter
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                search.clearFocus()
                if (names.contains(p0)) {
                    adapter.filter.filter(p0)
                } else {
                    Toast.makeText(requireContext(), "Item not found", Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }
        })

    }

}