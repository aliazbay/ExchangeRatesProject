package com.aliazbay.convertercurrency

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CurrencyAdapter(private val currencies: Map<String, Float>) :
    RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCurrencyName: TextView = itemView.findViewById(R.id.tv_currency_name)
        val tvCurrencyRate: TextView = itemView.findViewById(R.id.tv_currency_rate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return CurrencyViewHolder(view)
    }

    override fun getItemCount(): Int = currencies.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val item = currencies.entries.toList()[position]
        holder.tvCurrencyName.text = item.key
        holder.tvCurrencyRate.text = item.value.toString()
    }
}
