package com.softsquared.template.kotlin.src.main.hotelSeoulAcm

import android.content.Intent
import android.os.Bundle
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityHotelSeoulAcmBinding
import com.softsquared.template.kotlin.src.main.home.HomeFragment

class HotelSeoulAcmActivity : BaseActivity<ActivityHotelSeoulAcmBinding>
        (ActivityHotelSeoulAcmBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.hotelSeoulRoomReservationBtn.setOnClickListener {
//            val intent = Intent(this, HomeFragment::class.java)
//            startActivity(intent)
            finish()
        }
    }

}