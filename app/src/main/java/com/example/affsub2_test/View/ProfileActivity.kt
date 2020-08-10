package com.example.affsub2_test.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.affsub2_test.Model.Profile
import com.example.affsub2_test.R
import com.example.affsub2_test.ViewModel.ProfileViewModel
import java.io.Serializable

class ProfileActivity : AppCompatActivity() {

    lateinit var profileImage: ImageView
    lateinit var profileName: TextView
    lateinit var profileAge: TextView
    lateinit var profilePhone: TextView
    lateinit var profileEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        fillActivity()
    }

    fun fillActivity(): Unit {
        var id: Long = intent.extras?.get("id") as Long
        var profile = ProfileViewModel.profiles.get(id.toInt())

        profileImage = findViewById(R.id.profileImage)
        profileName = findViewById(R.id.profileName)
        profileAge = findViewById(R.id.profileAge)
        profilePhone = findViewById(R.id.profilePhone)
        profileEmail = findViewById(R.id.profileEmail)

        if (profile is Profile) {
            profileImage.setImageBitmap(profile.picture)
            profileName.setText(profile.name)
            profileAge.setText(profile.age)
            profilePhone.setText(profile.phone)
            profileEmail.setText(profile.email)
        } else {
            Toast.makeText(this, "No profile", Toast.LENGTH_SHORT).show()
        }

    }
}