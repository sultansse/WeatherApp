package com.example.weatherapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!


    private var _bindingActivity: ActivityMainBinding? = null
    private val bindingActivity get() = _bindingActivity!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_settings, container, false)

//        binding.root.findViewById<ToggleButton>(R.id.temperature_format_toggle).setOnClickListener(){
//            //todo change text string resource for whole activity , it means everywhere
//            binding.root.findViewById<R.a>()
//        }

        return root
    }

}