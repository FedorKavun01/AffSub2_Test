package com.example.affsub2_test

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class Profile(var name: String,
                   var picture: Bitmap,
                   var age: String,
                   var phone: String,
                   var email: String) {

}