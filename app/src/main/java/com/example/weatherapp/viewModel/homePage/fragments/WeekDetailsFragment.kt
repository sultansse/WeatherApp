package com.example.weatherapp.viewModel.homePage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeekDetailsBinding


class WeekDetailsFragment : Fragment() {

    private var _binding: FragmentWeekDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeekDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // not good /stacking
        binding.button.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.action_to_homeFragment)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
