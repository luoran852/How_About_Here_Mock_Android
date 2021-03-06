package com.softsquared.template.kotlin.src.main.hotelReservCheck

import android.content.Intent
import android.os.Bundle
import com.google.android.material.internal.ContextUtils.getActivity
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityReservationCheckBinding
import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.ReservCheckBeforeFragment
import com.softsquared.template.kotlin.src.main.search.SearchNewFragment
import com.softsquared.template.kotlin.src.main.search.SearchRoomFragment


class ReservCheckActivity : BaseActivity<ActivityReservationCheckBinding>
        (ActivityReservationCheckBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //나가기 버튼
        binding.hotelReservationBackBtn.setOnClickListener {
            finish()
        }

        //현재 페이지의 양쪽에 보유해야하는 페이지 수를 설정
        binding.hotelReservationCheckViewpager.offscreenPageLimit = 2

        //텝레이아웃과 뷰페이저를 연결
        binding.hotelReservationCheckTabLayout.setupWithViewPager(binding.hotelReservationCheckViewpager)

        //뷰페이저 어뎁터 설정 연결
        binding.hotelReservationCheckViewpager.adapter = ReservPageAdapter(supportFragmentManager, 3)


    }
}