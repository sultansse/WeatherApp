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
                R.id.settingsFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onBackPressed() {
        val dialog = Dialog(this@MainActivity)
        dialog.setContentView(R.layout.custom_exit_dialog)

        val dialogButtonExit = dialog.findViewById(R.id.textViewYes) as TextView
        val dialogButtonCancel = dialog.findViewById(R.id.textViewNo) as TextView

        dialogButtonCancel.setOnClickListener { // dismiss the dialog
            dialog.dismiss()
        }
        dialogButtonExit.setOnClickListener { // dismiss the dialog and exit the exit
            dialog.dismiss()
            finish()
        }
        dialog.show()
    }


}
