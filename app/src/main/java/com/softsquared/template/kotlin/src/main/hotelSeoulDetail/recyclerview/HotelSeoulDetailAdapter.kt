package com.softsquared.template.kotlin.src.main.hotelSeoulDetail.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.recyclerview.ReservCheckBeforeViewHolder
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.HotelSeoulDetailActivity
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.Room

class  AcmRoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

// room adapter
class AcmRoomAdapter() : RecyclerView.Adapter<AcmRoomViewHolder>() {

//    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
//
////        val img = itemView.findViewById<ImageView>(R.id.img_hotel) // 객실 이미지
////        val name = itemView.findViewById<TextView>(R.id.room_name) // 객실 이름
////        val price = itemView.findViewById<TextView>(R.id.room_price) // 객실 가격
////        val roomInfo =itemView.findViewById<TextView>(R.id.room_info) // 2인 기준, 최대 2인
//
//    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_detail_room_item, parent, false)//뷰를 붙여줌
//        return CustomViewHolder(view)
//                .apply {
//
//                }
//    }
//
//    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        //holder.image.setImageResource.(goodsList.get(position).image)
//
////        Glide.with(holder.img).load(RoomList.get(position).img).into(holder.img)
//////        holder.extraInfo.text= RoomList.get(position).extraInfo
////        holder.price.text = RoomList.get(position).price.toString()
////        holder.roomInfo.text = RoomList.get(position).roomInfo
////        holder.name.text = RoomList.get(position).name
//
//        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, HotelSeoulDetailActivity::class.java)
//
//
//        }
//
//
//    }

    override fun getItemCount(): Int {
//        return RoomList.size
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcmRoomViewHolder {
        val acmRoomViewHolder = AcmRoomViewHolder(
            LayoutInflater.from(parent.context).
            inflate(R.layout.activity_hotel_seoul_detail_room_item, parent, false)
        )

        return acmRoomViewHolder
    }

    override fun onBindViewHolder(holder: AcmRoomViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

class AcmFacilityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

// facility adapter
class AcmFacilityAdapter() : RecyclerView.Adapter<AcmFacilityViewHolder>() {

//    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
//        val img = itemView.findViewById<ImageView>(R.id.img_facility)
//    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_detail_facility_item,
//                parent, false)//뷰를 붙여줌
//
//        return CustomViewHolder(view)
//                .apply {
//
//                }
//    }
//
//    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//
////        Glide.with(holder.img).load(FacilityList.get(position)).into(holder.img)
//
//    }

    override fun getItemCount(): Int {
//        return FacilityList.size
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcmFacilityViewHolder {
        val acmFacilityViewHolder = AcmFacilityViewHolder(
            LayoutInflater.from(parent.context).
            inflate(R.layout.activity_hotel_seoul_detail_facility_item, parent, false)
        )

        return acmFacilityViewHolder
    }

    override fun onBindViewHolder(holder: AcmFacilityViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}

class AcmNoticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

// notice adapter
class AcmNoticeAdapter() : RecyclerView.Adapter<AcmNoticeViewHolder>() {


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_detail_notice_noti_item1,
//                parent, false)
//
//    }
//
//    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
////        holder.notice.text = noticeList.get(position)
//    }

    override fun getItemCount(): Int {
//        return noticeList.size
        return 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcmNoticeViewHolder {
        val acmNoticeViewHolder = AcmNoticeViewHolder(
            LayoutInflater.from(parent.context).
            inflate(R.layout.activity_hotel_seoul_detail_notice_noti_item1, parent, false)
        )

        return acmNoticeViewHolder
    }

    override fun onBindViewHolder(holder: AcmNoticeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcmNoticeViewHolder {
//        val acmNoticeViewHolder = AcmNoticeViewHolder(
//            LayoutInflater.from(parent.context).
//            inflate(R.layout.activity_hotel_seoul_detail_notice_noti_item1, parent, false)
//        )
//
//        return acmNoticeViewHolder
//    }
//
//    override fun onBindViewHolder(holder: AcmNoticeViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }

}

class AcmInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

//info adapter
class AcmInfoAdapter() : RecyclerView.Adapter<AcmInfoViewHolder>() {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_detail_notice_info_item2,
//                parent, false)//뷰를 붙여줌
//
//    }
//
//    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
////        holder.info.text = infoList.get(position)
//    }

    override fun getItemCount(): Int {
//        return infoList.size
        return 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcmInfoViewHolder {
        val acmInfoViewHolder = AcmInfoViewHolder(
            LayoutInflater.from(parent.context).
            inflate(R.layout.activity_hotel_seoul_detail_notice_info_item2, parent, false)
        )

        return acmInfoViewHolder
    }

    override fun onBindViewHolder(holder: AcmInfoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

class AcmRefundViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

// refund adapter
class AcmRefundAdapter() : RecyclerView.Adapter<AcmRefundViewHolder>() {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_detail_notice_refund_item3,
//                parent, false)//뷰를 붙여줌
//
//        return AcmRefundAdapter.CustomViewHolder(view)
//                .apply {
//
//                }
//    }
//
//    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
////        holder.refund.text = refundList.get(position)
//    }

    override fun getItemCount(): Int {
//        return refundList.size
        return 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcmRefundViewHolder {
        val acmRefundViewHolder = AcmRefundViewHolder(
            LayoutInflater.from(parent.context).
            inflate(R.layout.activity_hotel_seoul_detail_notice_refund_item3, parent, false)
        )

        return acmRefundViewHolder
    }

    override fun onBindViewHolder(holder: AcmRefundViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

class AcmRevieweViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

// review adapter
class AcmReviewAdapter : RecyclerView.Adapter<AcmRevieweViewHolder>() {

//    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
//
//        val profile = itemView.findViewById<ImageView>(R.id.img_review_profile) // 사용자 프로필 사진
//        val nickName = itemView.findViewById<TextView>(R.id.review_nickname) // 사용자 닉네임
////        val grade = itemView.findViewById<TextView>(R.id.review_rating_star) // 평점 (5점 만점)
//        val update = itemView.findViewById<TextView>(R.id.review_update) // 업데이트 날짜 (1일 전)
//        val roomName = itemView.findViewById<TextView>(R.id.review_room) // 숙소 이름
//        val review_content = itemView.findViewById<TextView>(R.id.review_txt) // 리뷰 내용
//        val room_img = itemView.findViewById<ImageView>(R.id.img_review_room) // 리뷰 객실 사진
//
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : AcmRevieweViewHolder {
//        val reservCheckBeforeViewHolder = ReservCheckBeforeViewHolder(
//            LayoutInflater.from(parent.context).
//            inflate(R.layout.fragment_reservation_check_before_item, parent, false))
//        LayoutInflater.from(parent.context).inflate(R.layout.activity_hotel_seoul_detail_review_item, parent, false)
        val acmRevieweViewHolder = AcmRevieweViewHolder(
            LayoutInflater.from(parent.context).
            inflate(R.layout.activity_hotel_seoul_detail_review_item, parent, false)
        )

        return acmRevieweViewHolder

    }

//    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//
////        Glide.with(holder.profile).load(reviewList.get(position).profile).into(holder.profile) //프로필 이미지
////        holder.nickName.text = reviewList.get(position).nickname // 사용자 닉네임
////        holder.update.text = reviewList.get(position).createdAt // 업데이트 날짜 (1일 전)
////        holder.roomName.text = reviewList.get(position).roomName // 숙소 이름
////        holder.review_content.text = reviewList.get(position).content // 리뷰 내용
////        Glide.with(holder.room_img).load(reviewList.get(position).img).into(holder.room_img) //객실 이미지
//    }

    override fun getItemCount(): Int {
//        return reviewList.size
        return 10
    }

    override fun onBindViewHolder(holder: AcmRevieweViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}