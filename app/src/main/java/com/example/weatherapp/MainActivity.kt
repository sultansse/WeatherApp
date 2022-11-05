package com.example.weatherapp

import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.weatherapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavigationView

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController


        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.newsFragment,
                R.id.searchFragment,
                R.id.aboutFragment,
                R.id.settingsFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onBackPressed() {
        // creating custom dialog
        val dialog = Dialog(this@MainActivity)
        // setting content view to dialog
        dialog.setContentView(R.layout.custom_exit_dialog)
        // getting reference of TextView
        val dialogButtonYes = dialog.findViewById(R.id.textViewYes) as TextView
        val dialogButtonNo = dialog.findViewById(R.id.textViewNo) as TextView
        // click listener for No
        dialogButtonNo.setOnClickListener { // dismiss the dialog
            dialog.dismiss()
        }
        // click listener for Yes
        dialogButtonYes.setOnClickListener { // dismiss the dialog and exit the exit
            dialog.dismiss()
            finish()
        }
        // show the exit dialog
        dialog.show()
    }

}
