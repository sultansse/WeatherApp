package com.example.weatherapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.weatherapp.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

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
        val names = arrayOf("Абай", "Акколь", "Аксай", "Аксу", "Актау", "Актобе",
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
            "Шахтинск", "Шемонаиха", "Шу", "Шымкент", "Щучинск", "Экибастуз")

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            names
        )
        listView.adapter = adapter
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                search.clearFocus()
                if(names.contains(p0)) {
                    adapter.filter.filter(p0)
                }else{
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}