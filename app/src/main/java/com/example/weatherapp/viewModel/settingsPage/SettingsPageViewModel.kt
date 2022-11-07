package com.example.weatherapp.viewModel.settingsPage

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import com.example.weatherapp.R
import com.example.weatherapp.repository.Repository
import com.example.weatherapp.view.SettingsFragment

class SettingsPageViewModel : ViewModel() {

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


    fun formatChanged(temperatureFormat: String){
        if (temperatureFormat == "°F"){
            Repository().formatOfTemperature = "°C"
        }else{
            Repository().formatOfTemperature = "°F"
        }
    }

}