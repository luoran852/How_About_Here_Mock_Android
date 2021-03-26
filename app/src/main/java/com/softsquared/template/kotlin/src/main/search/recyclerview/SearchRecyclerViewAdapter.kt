package com.softsquared.template.kotlin.src.main.search.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R

class SearchRecyclerViewAdapter : RecyclerView.Adapter<SearchItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
        val searchItemViewHolder = SearchItemViewHolder(
            LayoutInflater.from(parent.context).
            inflate(R.layout.layout_search_hotel_seoul_item, parent, false))

        return searchItemViewHolder
    }

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}