package com.example.affsub2_test

import android.graphics.Bitmap
import com.squareup.picasso.Picasso
import kotlinx.coroutines.runBlocking

data class Response(var results: Array<OBJS>) {
    data class OBJS(var name: Name, var picture: Picture, var dob: Dob, var email: String, var phone: String)

    data class Name(var first: String, var last: String) {
        fun getFullName(): String {
            return "$first $last"
        }
    }

    data class Picture(var thumbnail: String)

    data class Dob(var age: String)

    fun getProfile(): Profile {
        var result = results.get(0)
        var picture: Bitmap
        runBlocking {
            picture = Picasso.get().load(result.picture.thumbnail).get()
        }
        return Profile(result.name.getFullName(), picture, result.dob.age, result.phone, result.email)
    }
}