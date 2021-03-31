package com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.model.Result

class ReservCheckBefoRecycAdapter(private val ReservList: List<Result>) : RecyclerView.Adapter<ReservCheckBefoRecycAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val remainTime = itemView.findViewById<TextView>(R.id.reservation_check_time) //1일 6시간 28분 뒤 입실 가능
        val hotelImg = itemView.findViewById<ImageView>(R.id.reserv_check_hotel_img) //호텔 이미지
        val hotelName = itemView.findViewById<TextView>(R.id.reservation_check_name) //호텔 인 나인 강남
        val roomName = itemView.findViewById<TextView>(R.id.reservation_check_room_name) //스탠다드 더블
        val checkInString = itemView.findViewById<TextView>(R.id.reservation_check_check_in_date) //4.1 (목) 15:00
        val checkOutString = itemView.findViewById<TextView>(R.id.reservation_check_check_out_date) //4.2 (금) 12:00
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_reservation_check_before_item, parent, false)//뷰를 붙여줌
        return CustomViewHolder(view)
                .apply {

                }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.remainTime.text = ReservList.get(position).remainTime //1일 6시간 28분 뒤 입실 가능
        Glide.with(holder.hotelImg).load(ReservList.get(position).img).into(holder.hotelImg) // 호텔 이미지
        holder.hotelName.text = ReservList.get(position).acmName //호텔 인 나인 강남
        holder.roomName.text = ReservList.get(position).roomName //스탠다드 더블
        holder.checkInString.text = ReservList.get(position).checkInString //4.1 (목) 15:00
        holder.checkOutString.text = ReservList.get(position).checkOutString //4.1 (목) 15:00

    }

    override fun getItemCount(): Int {
        return ReservList.size
    }


}