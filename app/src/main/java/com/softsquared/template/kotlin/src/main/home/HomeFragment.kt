package com.softsquared.template.kotlin.src.main.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHomeBinding
import com.softsquared.template.kotlin.src.main.home.models.HomeResponse
import com.softsquared.template.kotlin.src.main.home.models.HotelResort
import com.softsquared.template.kotlin.src.main.home.recyclerview.HomeRecyclerAdapter
import com.softsquared.template.kotlin.src.main.hotelArea.HotelAreaFragment
import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.ReservCheckService
import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.model.Result
import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.recyclerview.ReservCheckBefoRecycAdapter
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.HotelSeoulDetailActivity


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind,
        R.layout.fragment_home), HomeFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoadingDialog(context!!)
        HomeService(this).tryGetHome()

        // 호텔 아이콘 클릭
        binding.homeHotel.setOnClickListener {
            fragmentManager?.beginTransaction()?.add(R.id.main_frm, HotelAreaFragment())
                    ?.addToBackStack(null)?.commit()
        }

    }

    override fun onGetHomeSuccess(response: HomeResponse) {
        dismissLoadingDialog()

        if(response.code == 1000) {

            Log.e(ApplicationClass.TAG, "onGetHomeSuccess: ${response.message}")
            Log.e(ApplicationClass.TAG, "${response.result}")
            // 홈화면 호텔 성공
            response.message?.let { showCustomToast(it) }

            val result = response.result[0].hotelResort

            var hotelList: List<HotelResort> = result
            binding.homeHotelRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.homeHotelRecyclerView.setHasFixedSize(true)
            binding.homeHotelRecyclerView.adapter = hotelList?.let { HomeRecyclerAdapter(it) }

        }
    }

    override fun onGetHomeFailure(message: String, response: HomeResponse) {
        dismissLoadingDialog()

        Log.e(ApplicationClass.TAG, "onGetHomeFailure: ${response.message}")
        when (response.code) {

            //jwt토큰 존재 x
            2000 -> {
                showCustomToast("$message")
            }

            //jwt토큰 유효하지 않음
            3000 -> {
                showCustomToast("$message")
            }

        }
    }

}