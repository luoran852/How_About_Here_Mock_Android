package com.softsquared.template.kotlin.src.main.hotelArea

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHotelAreaBinding
import com.softsquared.template.kotlin.src.main.hotelSeoulAll.HotelSeoulAllFragment

class HotelAreaFragment : BaseFragment<FragmentHotelAreaBinding>(FragmentHotelAreaBinding::bind,
        R.layout.fragment_hotel_area) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // back 버튼 클릭
        binding.hotelAreaBackBtn.setOnClickListener {
            fragmentManager?.beginTransaction()?.remove(this)?.commit()
        }

        // 서울전체 chip 버튼 클릭
        binding.hotelAreaSeoulAllChipBtn.setOnClickListener {
            fragmentManager?.beginTransaction()?.add(R.id.main_frm, HotelSeoulAllFragment())
                ?.addToBackStack(null)?.commit()
        }

    }

}