package com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R

class ReservCheckBeforeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // 뷰들을 가져온다.
    private val hotelSeoulAllImg = itemView.findViewById<ImageView>(R.id.hotel_seoul_all_img)
    private val hotelSeoulAllName = itemView.findViewById<TextView>(R.id.hotel_seoul_all_name)

}