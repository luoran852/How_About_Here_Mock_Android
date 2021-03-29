package com.softsquared.template.kotlin.src.main.hotelSeoulDetail.recyclerview

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.TAG
import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.recyclerview.ReservCheckBeforeViewHolder
import com.softsquared.template.kotlin.src.main.hotelSeoulAcm.HotelSeoulAcmActivity
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.HotelSeoulDetailActivity
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.Review
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.Room
import kotlin.math.log

// room adapter
class AcmRoomAdapter(private val RoomList: List<Room>) : RecyclerView.Adapter<AcmRoomAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val img = itemView.findViewById<ImageView>(R.id.img_hotel) // 객실 이미지
        val name = itemView.findViewById<TextView>(R.id.room_name) // 객실 이름
        val price = itemView.findViewById<TextView>(R.id.room_price) // 객실 가격
        val roomInfo =itemView.findViewById<TextView>(R.id.room_info) // 2인 기준, 최대 2인

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_detail_room_item, parent, false)//뷰를 붙여줌
        return CustomViewHolder(view)
                .apply {

                }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        Glide.with(holder.img).load(RoomList.get(position).img).into(holder.img)
        holder.price.text = RoomList.get(position).price.toString()
        holder.roomInfo.text = RoomList.get(position).roomInfo
        holder.name.text = RoomList.get(position).name

        holder.itemView.setOnClickListener {
            Log.e(TAG, "onBindViewHolder: 서울전체에서 recyclerview item클릭됨")
            val intent = Intent(holder.itemView.context, HotelSeoulAcmActivity::class.java)
            Log.e(TAG, "서울전체 recyclerview에서 클릭된 item의 roomIdx = ${RoomList.get(position).roomIdx}")
            intent.putExtra("roomIdx", RoomList.get(position).roomIdx)
            ContextCompat.startActivity(holder.itemView.context, intent, null)

        }


    }

    override fun getItemCount(): Int {
        return RoomList.size
    }

}

// facility adapter
class AcmFacilityAdapter(private val FacilityList: List<String>) : RecyclerView.Adapter<AcmFacilityAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val img = itemView.findViewById<ImageView>(R.id.img_facility)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_detail_facility_item,
                parent, false)//뷰를 붙여줌

        return CustomViewHolder(view)
                .apply {

                }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        Glide.with(holder.img).load(FacilityList.get(position)).into(holder.img)

    }

    override fun getItemCount(): Int {
        return FacilityList.size
    }


}


// notice adapter
class AcmNoticeAdapter(private val noticeList: List<String>) : RecyclerView.Adapter<AcmNoticeAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val notice = itemView.findViewById<TextView>(R.id.room_notice1) // 공지사항
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_detail_notice_noti_item1,
                parent, false)//뷰를 붙여줌

        return CustomViewHolder(view)
                .apply {

                }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.notice.text = "ㆍ" + noticeList.get(position)
    }

    override fun getItemCount(): Int {
        return noticeList.size
    }

}

//info adapter
class AcmInfoAdapter(private val infoList: List<String>) : RecyclerView.Adapter<AcmInfoAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val info = itemView.findViewById<TextView>(R.id.room_notice2) // 기본정보

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_detail_notice_info_item2,
                parent, false)//뷰를 붙여줌

        return CustomViewHolder(view)
                .apply {


                }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.info.text = "ㆍ" + infoList.get(position)
    }

    override fun getItemCount(): Int {
        return infoList.size
    }

}

// refund adapter
class AcmRefundAdapter(private val refundList: List<String>) : RecyclerView.Adapter<AcmRefundAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val refund = itemView.findViewById<TextView>(R.id.room_notice3) // 취소 및 환불 규정

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_detail_notice_refund_item3,
                parent, false)//뷰를 붙여줌

        return CustomViewHolder(view)
                .apply {

                }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.refund.text = "ㆍ" + refundList.get(position)
    }

    override fun getItemCount(): Int {
        return refundList.size
    }

}

// review adapter
class AcmReviewAdapter(private val reviewList: List<Review>) : RecyclerView.Adapter<AcmReviewAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val profile = itemView.findViewById<ImageView>(R.id.img_review_profile) // 사용자 프로필 사진
        val nickName = itemView.findViewById<TextView>(R.id.review_nickname) // 사용자 닉네임
//        val grade = itemView.findViewById<TextView>(R.id.review_rating_star) // 평점 (5점 만점)
        val update = itemView.findViewById<TextView>(R.id.review_update) // 업데이트 날짜 (1일 전)
        val roomName = itemView.findViewById<TextView>(R.id.review_room) // 숙소 이름
        val review_content = itemView.findViewById<TextView>(R.id.review_txt) // 리뷰 내용
        val room_img = itemView.findViewById<ImageView>(R.id.img_review_room) // 리뷰 객실 사진

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : CustomViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_detail_review_item, parent, false)//뷰를 붙여줌
        return CustomViewHolder(view)
                .apply {

                }

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        Glide.with(holder.profile).load(reviewList.get(position).profile).into(holder.profile) //프로필 이미지
        holder.nickName.text = reviewList.get(position).nickname // 사용자 닉네임
        holder.update.text = reviewList.get(position).createdAt // 업데이트 날짜 (1일 전)
        holder.roomName.text = reviewList.get(position).roomName // 숙소 이름
        holder.review_content.text = reviewList.get(position).content // 리뷰 내용
//        Glide.with(holder.room_img).load(reviewList.get(position).img[0]).into(holder.room_img) //객실 이미지
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }

}