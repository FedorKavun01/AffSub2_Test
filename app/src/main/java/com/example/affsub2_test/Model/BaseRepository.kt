package com.example.affsub2_test.Model

import retrofit2.Response
import java.io.IOException

open class BaseRepository {

    private val TAG = "BaseRepository"

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, errorMessage: String): T? {
        val result = safeApiResult(call, errorMessage)
        var data: T? = null

        when(result) {
            is Result.Success -> {
                data = result.data
//                Log.d(TAG, "safeApiCall: Success")
            }
            is Result.Error -> {
//                Log.d(TAG, "safeApiCall: $errorMessage")
                println("Error")
            }
        }

        return data
    }

    private suspend fun <T : Any> safeApiResult(call: suspend () -> Response<T>, errorMessage: String): Result<T> {
        val response = call.invoke()
//        Log.d(TAG, "safeApiResult: Start")
        if (response.isSuccessful) {
            return Result.Success(response.body()!!)
        }
//        Log.d(TAG, "safeApiResult: Error")
        return Result.Error(IOException(errorMessage))
    }
}