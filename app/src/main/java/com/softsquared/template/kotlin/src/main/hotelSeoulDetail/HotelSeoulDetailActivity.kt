package com.softsquared.template.kotlin.src.main.hotelSeoulDetail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityHotelSeoulDetailBinding
import com.softsquared.template.kotlin.src.main.hotelSeoulAcm.HotelSeoulAcmActivity
import com.softsquared.template.kotlin.src.main.hotelSeoulAll.recyclerview.SeoulAllRecyclerViewAdapter
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.HotelDetailResponse
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.Review
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.Room
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.recyclerview.*

class HotelSeoulDetailActivity : BaseActivity<ActivityHotelSeoulDetailBinding>
    (ActivityHotelSeoulDetailBinding::inflate), HotelSeoulDetailActivityView {

    val TAG : String = "태그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val acmIdx = intent.getIntExtra("acmIdx", 0)
        val checkIn = 20210403
        val checkOut = 20210404

        val editor = ApplicationClass.sSharedPreferences.edit()
        editor.putInt("acmIdx", acmIdx)
        editor.apply()
        editor.commit()
        showLoadingDialog(this)
        HotelDetailService(this).tryGetHotelDetail(acmIdx, checkIn, checkOut)

    }

    //get 성공
    override fun onGetHotelDetailSuccess(response: HotelDetailResponse) {
        dismissLoadingDialog()

        if(response.code == 1000) {

            Log.e(TAG, "onGetHotelDetailSuccess: ${response.message}")
            Log.e(TAG, "${response.result[0]}")
            // 숙소 상세 조회 성공
            response.message?.let { showCustomToast(it) }

            val result = response.result

            //메인 사진
            Glide.with(this).load(result[0]?.img[0]).into(binding.accImg)

            //숙소 정보
            binding.accName.text = result[0].name //노보텔 앰배서더
            binding.accWhere.text = result[0].location //서울 용산구
            binding.accStarScore.text = result[0].reviewAverage.toString() //(평점)4.9
            binding.accShowReview.text = "리뷰" + result[0].reviewCnt + "개보기 >" //리뷰 441개 보기
            binding.roomActivity.textCheckIn.text = result[0].checkIn //3.25 목
            binding.roomActivity.textCheckOut.text = result[0].checkOut //3.26 금
            binding.roomActivity.textSleep.text = result[0].night //1박

            //룸 리스트
            var RoomList: List<Room>? = result[0].rooms
            binding.roomActivity.rvRoom.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.roomActivity.rvRoom.setHasFixedSize(true)
            binding.roomActivity.rvRoom.adapter = RoomList?.let { AcmRoomAdapter(it) }


            //인트로 설명 (최신 시설을 갖춘~ 만족을 선사합니다)
            binding.roomIntro.text = result[0].intro

            //편의시설
            var FacilityList: List<String>? = result[0].facility
            binding.roomFacility.rvFacility.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.roomFacility.rvFacility.setHasFixedSize(true)
            binding.roomFacility.rvFacility.adapter = FacilityList?.let { AcmFacilityAdapter(it) }


            //공지사항
            var noticeList: List<String>? = result[0].notice
            binding.roomExtraInfo.rvNotice.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.roomExtraInfo.rvNotice.setHasFixedSize(true)
            binding.roomExtraInfo.rvNotice.adapter = noticeList?.let { AcmNoticeAdapter(it) }

            //기본정보
            var infoList: List<String>? = result[0].info
            binding.roomExtraInfo.rvInfo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.roomExtraInfo.rvInfo.setHasFixedSize(true)
            binding.roomExtraInfo.rvInfo.adapter = infoList?.let { AcmInfoAdapter(it) }


            //환불규정
            var refundList: List<String>? = result[0].refund
            binding.roomExtraInfo.rvRefund.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.roomExtraInfo.rvRefund.setHasFixedSize(true)
            binding.roomExtraInfo.rvRefund.adapter = refundList?.let { AcmRefundAdapter(it) }


            //리뷰
            var reviewList: List<Review> = result[0].reviews
            binding.review.rvReview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.review.rvReview.setHasFixedSize(true)
            binding.review.rvReview.adapter = reviewList?.let { AcmReviewAdapter(it) }


        }

    }

    //get 실패
    override fun onGetHotelDetailFailure(message: String, response: HotelDetailResponse) {
        dismissLoadingDialog()

        Log.e(TAG, "onGetHotelDetailFailure: ${response.message}")
        when(response.code) {

            //jwt 토큰이 존재하지 않음
            2000 -> {
                showCustomToast("$message")
            }

            //jwt 토큰이 유효하지 않음
            3000 -> {
                showCustomToast("$message")
            }

        }
    }



}