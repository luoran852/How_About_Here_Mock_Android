package com.softsquared.template.kotlin.src.main.myLocation.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R

class MyLocationRecyclerViewAdpater : RecyclerView.Adapter<MyLocationItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyLocationItemViewHolder {
        val myLocationItemViewHolder = MyLocationItemViewHolder(
            LayoutInflater.from(parent.context).
        inflate(R.layout.fragment_my_location_item, parent, false))

        return myLocationItemViewHolder
    }

    override fun onBindViewHolder(holder: MyLocationItemViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}