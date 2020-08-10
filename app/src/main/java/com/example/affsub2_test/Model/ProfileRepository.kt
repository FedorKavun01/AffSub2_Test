package com.example.affsub2_test.Model

import android.util.Log

class ProfileRepository(var api : APIService) : BaseRepository() {

    private val TAG = "ProfileRepository"

    suspend fun getProfile(): Profile? {
        var itemResponse = safeApiCall(
            call = { api.getProfile().await() }, errorMessage = ""
        )
        if (itemResponse != null) {
//            Log.d(TAG, "getProfile: success")
            return itemResponse.getProfile()
        } else {
//            Log.d(TAG, "getProfile: exception")
            println("Exception")
            return null
        }
    }
}