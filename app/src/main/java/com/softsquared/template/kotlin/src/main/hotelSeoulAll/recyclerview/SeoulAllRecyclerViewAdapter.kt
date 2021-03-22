package com.softsquared.template.kotlin.src.main.hotelSeoulAll.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R

class SeoulAllRecyclerViewAdapter : RecyclerView.Adapter<SeoulAllItemViewHolder>() {

    // 뷰홀더와 레이아웃 연결
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeoulAllItemViewHolder {

        val seoulAllItemViewHolder = SeoulAllItemViewHolder(LayoutInflater.from(parent.context).
        inflate(R.layout.layout_hotel_seoul_all_item, parent, false))

        return seoulAllItemViewHolder

    }

    // 뷰가 묶였을때 데이터를 뷰홀더에 넘겨준다.
    override fun onBindViewHolder(holder: SeoulAllItemViewHolder, position: Int) {

    }

    // 보여줄 목록의 개수
    override fun getItemCount(): Int {
        return 10
    }
}