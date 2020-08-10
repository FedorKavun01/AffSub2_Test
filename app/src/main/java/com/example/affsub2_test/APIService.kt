package com.example.affsub2_test

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIService {
    @GET("api")
    fun getProfile(): Deferred<Response<com.example.affsub2_test.Response>>
}

object NetworkService {
    private val baseUrl = "https://randomuser.me/"
    private val retrofit = Retrofit.Builder().
        baseUrl(baseUrl).
        addCallAdapterFactory(CoroutineCallAdapterFactory()).
        addConverterFactory(GsonConverterFactory.create()).build()

    fun getSevice() = retrofit.create(APIService::class.java)
}