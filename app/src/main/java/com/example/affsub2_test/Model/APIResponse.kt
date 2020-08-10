package com.example.affsub2_test.Model

import android.graphics.Bitmap
import com.squareup.picasso.Picasso
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

data class APIResponse(var results: Array<OBJS>) {
    data class OBJS(var name: Name, var picture: Picture, var dob: Dob, var email: String, var phone: String)

    data class Name(var first: String, var last: String) {
        fun getFullName(): String {
            return "$first $last"
        }
    }

    data class Picture(var large: String)

    data class Dob(var age: String)

    fun getProfile(): Profile {
        var result = results.get(0)
        var picture: Bitmap? = null
        runBlocking {
            async {
                picture = Picasso.get().load(result.picture.large).get()
            }.await()
        }
        val age = result.dob.age + " years old"
        return Profile(result.name.getFullName(), picture, age, result.phone, result.email)
    }
}