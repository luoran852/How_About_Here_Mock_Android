package com.softsquared.template.kotlin.src.main.hotelSeoulAcm.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R

// 기본정보 adapter
class AcmInfoAdapter(private val InfoList: List<String>) : RecyclerView.Adapter<AcmInfoAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val info = itemView.findViewById<TextView>(R.id.acm_info_item_txt) // 기본정보
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_acm_info_item,
                parent, false)//뷰를 붙여줌

        return AcmInfoAdapter.CustomViewHolder(view)
                .apply {


                }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.info.text = "ㆍ" + InfoList.get(position)
    }

    override fun getItemCount(): Int {
        return InfoList.size
    }
}

// 환불정보 adapter
class AcmRefundAdapter(private val RefundList: List<String>) : RecyclerView.Adapter<AcmRefundAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val info = itemView.findViewById<TextView>(R.id.acm_refund_item_txt) // 환불정보
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_acm_refund_item,
                parent, false)//뷰를 붙여줌

        return AcmRefundAdapter.CustomViewHolder(view)
                .apply {


                }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.info.text = "ㆍ" + RefundList.get(position)
    }

    override fun getItemCount(): Int {
        return RefundList.size
    }
}