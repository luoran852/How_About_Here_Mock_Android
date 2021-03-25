package com.softsquared.template.kotlin.src.main.hotelSeoulAll.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.Result

class SeoulAllItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // 뷰들을 가져온다.
    private val hotelSeoulAllImg = itemView.findViewById<ImageView>(R.id.hotel_seoul_all_img)
    private val hotelSeoulAllName = itemView.findViewById<TextView>(R.id.hotel_seoul_all_name)
    private val hotelSeoulAllLocation = itemView.findViewById<TextView>(R.id.hotel_seoul_all_location)


}