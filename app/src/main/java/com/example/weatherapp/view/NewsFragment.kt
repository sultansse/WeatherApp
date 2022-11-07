package com.example.weatherapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentNewsBinding
import com.example.weatherapp.viewModel.NewsPage.NewsPageViewModel
import com.example.weatherapp.viewModel.NewsPage.recycler.DatasourceNews
import com.example.weatherapp.viewModel.NewsPage.recycler.ItemAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {

    private val adapter =  ItemAdapter(this)

    val viewModel: NewsPageViewModel by viewModels()
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(layoutInflater)
        return binding.root
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        val todayDataset = Datasource().loadTodayViews()
//        val todayRecyclerview = view.findViewById<RecyclerView>(R.id.todayDetailsRecycler)
//        todayRecyclerview?.adapter = TodayItemAdapter(this, todayDataset)
//        todayRecyclerview?.setHasFixedSize(true)

        val verticalNews = DatasourceNews().loadNewsViews()
        val newsRecyclerview = view.findViewById<RecyclerView>(R.id.recyclerView2)
        newsRecyclerview?.adapter = adapter
        adapter.submitList(verticalNews)
        newsRecyclerview?.setHasFixedSize(true)
    }

}