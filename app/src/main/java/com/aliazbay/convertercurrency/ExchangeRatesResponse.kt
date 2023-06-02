package com.aliazbay.convertercurrency

data class ExchangeRatesResponse(
    val base_code: String,
    val conversion_rates: Map<String, Float>
)
