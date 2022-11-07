package com.example.weatherapp.viewModel.settingsPage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.weatherapp.repository.Repository

class SettingsPageViewModel : ViewModel() {

    private val repository = Repository.getInstance()

    val currentTemperatureType = repository.currentTemperatureType.asLiveData()

    fun sendFeedback(context: Context) {

        val email = Intent(Intent.ACTION_SEND)
        email.type = "text/email"
        email.putExtra(Intent.EXTRA_EMAIL, arrayOf("ss.softwareit@gmail.com"))
        email.putExtra(Intent.EXTRA_SUBJECT, "Feedback")
        email.putExtra(Intent.EXTRA_TEXT, "Dear software engineers,")
        ContextCompat.startActivity(
            context, Intent.createChooser(email, "Send Feedback:"),
            bundleOf().getBundle(email.dataString)
        )
    }

    fun onToggleTemperatureFormat() {
        repository.toggleTemperatureType()
    }

    fun darkMode(isChecked: Boolean) {

//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        if (isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

}