package com.aliazbay.convertercurrency

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://v6.exchangerate-api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: CurrencyApiService by lazy {
        retrofit.create(CurrencyApiService::class.java)
    }
}
