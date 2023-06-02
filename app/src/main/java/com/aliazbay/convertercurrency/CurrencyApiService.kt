package com.aliazbay.convertercurrency

import retrofit2.http.GET

interface CurrencyApiService {
    @GET("v6/18c758c1a560d07413603a8e/latest/USD")
    suspend fun getExchangeRates(): ExchangeRatesResponse
}
