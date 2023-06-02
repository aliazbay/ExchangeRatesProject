package com.aliazbay.convertercurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvCurrencies = findViewById<RecyclerView>(R.id.rv_currencies)
        rvCurrencies.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val response = try {
                RetrofitInstance.api.getExchangeRates()
            } catch(e: Exception) {
                Log.e("MainActivity", "Error fetching exchange rates", e)
                null
            }
            if(response != null) {
                val adapter = CurrencyAdapter(response.conversion_rates)
                rvCurrencies.adapter = adapter
            }
        }

        lifecycleScope.launch {
            val response = try {
                RetrofitInstance.api.getExchangeRates()
            } catch(e: Exception) {
                Log.e("MainActivity", "Error fetching exchange rates", e)
                null
            }
            if(response != null) {
                response.conversion_rates.forEach {
                    Log.d("MainActivity", "Currency: ${it.key}, Rate: ${it.value}")
                }
            }
        }
    }
}




//class MainActivity : AppCompatActivity() {
  //  override fun onCreate(savedInstanceState: Bundle?) {
    //    super.onCreate(savedInstanceState)
    //    setContentView(R.layout.activity_main)
/*
        val rvCurrencies = findViewById<RecyclerView>(R.id.rv_currencies)
        rvCurrencies.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val response = try {
                RetrofitInstance.api.getExchangeRates()
            } catch(e: Exception) {
                Log.e("MainActivity", "Error fetching exchange rates", e)
                null
            }
            if(response != null) {
                val adapter = CurrencyAdapter(response.conversion_rates)
                rvCurrencies.adapter = adapter
            }
        }
    }
}
*/