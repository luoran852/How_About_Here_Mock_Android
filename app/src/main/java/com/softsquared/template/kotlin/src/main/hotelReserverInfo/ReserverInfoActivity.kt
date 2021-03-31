package com.softsquared.template.kotlin.src.main.hotelReserverInfo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityReserverInfoBinding
import com.softsquared.template.kotlin.src.main.hotelReserv.ReservationActivity

class ReserverInfoActivity : BaseActivity<ActivityReserverInfoBinding>
(ActivityReserverInfoBinding::inflate) {

    val TAG : String = "태그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e(TAG, "ReserverInfoActivity 예약자 정보 액티비티 실행됨")

        //예약자 정보에서 이름, 폰번호 입력하고 확인 누르면 예약 페이지로 값 전달
        binding.reserverInfoConfirmBtn.setOnClickListener {
            val intent = Intent(this, ReservationActivity::class.java)
            Log.e(TAG, "reserverName = ${binding.reserverNameEditTxt.text}")
            Log.e(TAG, "reserverPhone = ${binding.reserverPhoneNumEditTxt.text}")

            intent.putExtra("reserverName", binding.reserverNameEditTxt.text.toString())
            intent.putExtra("reserverPhone", binding.reserverPhoneNumEditTxt.text.toString())
            startActivity(intent)
        }
    }
}