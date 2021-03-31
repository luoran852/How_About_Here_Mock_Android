package com.softsquared.template.kotlin.src.main.hotelReserv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityPhoneCertificationBinding
import com.softsquared.template.kotlin.databinding.ActivityReservationBinding
import com.softsquared.template.kotlin.src.main.hotelReserv.model.ReservPageResponse
import com.softsquared.template.kotlin.src.main.hotelReserverInfo.ReserverInfoActivity

class ReservationActivity : BaseActivity<ActivityReservationBinding>
(ActivityReservationBinding::inflate), ReservationActivityView {

    val TAG : String = "태그"
    var reserverName: String? = null
    var reserverPhone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val acmIdx = ApplicationClass.sSharedPreferences.getInt("acmIdx", 0) //sf에 저장된 acmIdx 가져오기
        Log.e(TAG, "예약페이지에서 acmIdx = $acmIdx")
        val checkIn = 20210401
        val checkOut = 20210402
        val roomIdx = ApplicationClass.sSharedPreferences.getInt("roomIdx", 0) //sf에 저장된 roomIdx 가져오기
        Log.e(TAG, "예약페이지에서 roomIdx = $roomIdx")

        showLoadingDialog(this)
        ReservService(this).tryGetReservPage(acmIdx, roomIdx, checkIn, checkOut)

        // 예약자 정보 클릭하면 예약자이름, 휴대폰 번호 받아옴
        binding.reserverInfoLayout.setOnClickListener {
            val intent = Intent(this, ReserverInfoActivity::class.java)
            startActivity(intent)
        }



        // 예약자이름, 휴대폰 번호 받아옴
        reserverName = intent.getStringExtra("reserverName").toString()
        reserverPhone = intent.getStringExtra("reserverPhone").toString()
        val editor = ApplicationClass.sSharedPreferences.edit()
        editor.putString("reserverName", reserverName)
        editor.apply()
        Log.e(TAG, "reserverName 저장됨? reserverName = " +
                "${ApplicationClass.sSharedPreferences.getString("reserverName", "")}")

        Log.e(TAG, "reserverName = $reserverName")
        Log.e(TAG, "reserverPhone = $reserverPhone")



    }

    override fun onGetReservPageSuccess(response: ReservPageResponse) {
        dismissLoadingDialog()

        if(response.code == 1000) {

            Log.e(TAG, "onGetReservPageSuccess: ${response.message}")
            Log.e(TAG, "예약페이지 결과 = ${response.result}")
            // 예약 페이지 조회 성공
            response.message?.let { showCustomToast(it) }

            val result = response.result

            if (reserverName != null) {
                Log.e(TAG, "예약자 정보 띄우기 조건문 실행됨")
                //예약자 정보 띄우기
                binding.reserverInfoEditedName.text = reserverName
                binding.reserverInfoEditedPhone.text = reserverPhone
                binding.reserverInfoTxt.visibility = View.INVISIBLE
                binding.reserverInfoEditedName.visibility = View.VISIBLE
                binding.reserverInfoEditedPhone.visibility = View.VISIBLE
            }

            binding.reservHotelName.text = result[0].acmName //노보텔 앰배서더 동대문호텔 & 레지던스
            binding.reservRoomName.text = result[0].roomName //스탠다드 더블
            binding.reservRoomInfo.text = result[0].roomInfo //2인 기준 최대 2인
            binding.reservPriceTop.text = result[0].paymentAmount.toString() + "원" // 130000원
            binding.totalPrice.text = result[0].paymentAmount.toString() + "원" //130000원
            binding.textPay.text = result[0].paymentAmount.toString() + "원 결제하기" //130000원 결제하기
            binding.reservationTotalSleep.text = result[0].night //1박

        }
    }

    override fun onGetReservPageFailure(message: String, response: ReservPageResponse) {
        dismissLoadingDialog()
        Log.e(TAG, "onGetReservPageFailure: 예약페이지 조회 실패")

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