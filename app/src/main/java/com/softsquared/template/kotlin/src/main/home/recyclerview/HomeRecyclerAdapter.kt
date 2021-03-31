package com.softsquared.template.kotlin.src.main.home.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.main.home.models.HotelResort

class HomeRecyclerAdapter(private val HomeList: List<HotelResort>) : RecyclerView.Adapter<HomeRecyclerAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val hotelImg = itemView.findViewById<ImageView>(R.id.home_hotel_item_img) //호텔 이미지
        val hotelName = itemView.findViewById<TextView>(R.id.home_hotel_item_txt1) //호텔 인 나인 강남
        val location = itemView.findViewById<TextView>(R.id.home_hotel_item_location_txt3) //강남역 근처
        val price = itemView.findViewById<TextView>(R.id.home_hotel_item_price_txt4) //4.1 (목) 15:00
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_home_hotel_item, parent, false)//뷰를 붙여줌
        return CustomViewHolder(view)
            .apply {

            }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        Glide.with(holder.hotelImg).load(HomeList.get(position).img).into(holder.hotelImg) // 호텔 이미지
        holder.hotelName.text = HomeList.get(position).name //호텔 인 나인 강남
        holder.location.text = HomeList.get(position).surround //강남역 근처
        holder.price.text = HomeList.get(position).price.toString() + "원" //60,0000원

    }

    override fun getItemCount(): Int {
        return HomeList.size
    }


}