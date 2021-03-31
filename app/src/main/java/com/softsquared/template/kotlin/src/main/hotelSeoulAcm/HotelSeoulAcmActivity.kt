package com.softsquared.template.kotlin.src.main.hotelSeoulAcm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityHotelSeoulAcmBinding
import com.softsquared.template.kotlin.src.main.hotelReserv.ReservationActivity
import com.softsquared.template.kotlin.src.main.hotelSeoulAcm.model.AcmResponse
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.recyclerview.AcmInfoAdapter
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.recyclerview.AcmRefundAdapter

class HotelSeoulAcmActivity : BaseActivity<ActivityHotelSeoulAcmBinding>
        (ActivityHotelSeoulAcmBinding::inflate), HotelSeoulAcmActivityView {

    val TAG : String = "태그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val acmIdx = ApplicationClass.sSharedPreferences.getInt("acmIdx", 0) //sf에 저장된 acmIdx 가져오기
        val checkIn = 20210403
        val checkOut = 20210404
        val roomIdx = intent.getIntExtra("roomIdx", 0)

        Log.e(TAG, "숙소페이지에서 acmIdx = $acmIdx")
        Log.e(TAG, "숙소페이지에서 roomIdx = $roomIdx")

        val editor = ApplicationClass.sSharedPreferences.edit()
        editor.putInt("roomIdx", roomIdx)
        editor.apply()
        editor.commit()
        showLoadingDialog(this)
        AcmService(this).tryGetAcm(acmIdx, roomIdx, checkIn, checkOut)

//        binding.hotelSeoulSleep.bringToFront()

        //예약버튼 클릭하면 예약 페이지로 이동
        binding.hotelSeoulRoomReservationBtn.setOnClickListener {
            val intent = Intent(this, ReservationActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onGetAcmSuccess(response: AcmResponse) {
        dismissLoadingDialog()

        if(response.code == 1000) {

            Log.e(TAG, "onGetAcmSuccess: ${response.message}")
            Log.e(TAG, "${response.result[0]}")
            // 숙소 상세 조회 성공
            response.message?.let { showCustomToast(it) }

            val result = response.result

            //객실 사진
            Glide.with(this).load(result[0]?.img[0]).into(binding.hotelSeoulRoomImg)

            binding.hotelSeoulRoomName.text = result[0].name //스탠다드 더블
            binding.hotelSeoulRoomPrice.text = result[0].price.toString() + "원" // 137500원
            binding.hotelSeoulSleep.text = result[0].night //1박

            //기본정보
            var InfoList: List<String>? = result[0].info
            binding.acmInfoRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.acmInfoRecyclerview.setHasFixedSize(true)
            binding.acmInfoRecyclerview.adapter = InfoList?.let { AcmInfoAdapter(it) }

            //편의시설
            binding.hotelSeoulRoomFacilityDetail.text = result[0].facility // TV,옷장,금고,쇼파..

            //환불정보
            var RefundList: List<String>? = result[0].refund
            binding.acmRefundRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.acmRefundRecyclerview.setHasFixedSize(true)
            binding.acmRefundRecyclerview.adapter = RefundList?.let { AcmRefundAdapter(it) }

        }
    }

    override fun onGetAcmFailure(message: String, response: AcmResponse) {
        dismissLoadingDialog()

        Log.e(TAG, "onGetAcmFailure: 객실정보 조회 실패")
    }

}