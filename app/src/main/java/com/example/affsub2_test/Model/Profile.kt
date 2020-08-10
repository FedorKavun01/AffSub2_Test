package com.example.affsub2_test.Model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Profile(var name: String,
                   var picture: Bitmap?,
                   var age: String,
                   var phone: String,
                   var email: String) {

}