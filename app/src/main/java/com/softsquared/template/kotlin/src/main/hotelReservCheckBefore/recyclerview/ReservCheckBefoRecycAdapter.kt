package com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R

class ReservCheckBefoRecycAdapter : RecyclerView.Adapter<ReservCheckBeforeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservCheckBeforeViewHolder {

        val reservCheckBeforeViewHolder = ReservCheckBeforeViewHolder(
            LayoutInflater.from(parent.context).
        inflate(R.layout.fragment_reservation_check_before_item, parent, false))

        return reservCheckBeforeViewHolder
    }

    override fun onBindViewHolder(holder: ReservCheckBeforeViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}