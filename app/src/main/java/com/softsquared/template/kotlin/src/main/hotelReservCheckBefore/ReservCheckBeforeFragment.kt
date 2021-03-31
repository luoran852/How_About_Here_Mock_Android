package com.softsquared.template.kotlin.src.main.hotelReservCheckBefore

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.TAG
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentReservationCheckBeforeBinding
import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.model.ReservCheckResponse
import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.model.Result
import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.recyclerview.ReservCheckBefoRecycAdapter
import com.softsquared.template.kotlin.src.main.search.SearchNewFragment
import com.softsquared.template.kotlin.src.main.search.recyclerview.SearchRecyclerViewAdapter

class ReservCheckBeforeFragment : BaseFragment<FragmentReservationCheckBeforeBinding>
        (FragmentReservationCheckBeforeBinding::bind, R.layout.fragment_reservation_check_before), ReservCheckBeforeFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "onViewCreated: fragment_reservation_check_before")

//        fragmentManager?.beginTransaction()?.add(R.id.hotel_reservation_check_viewpager, SearchNewFragment())
//            ?.addToBackStack(null)?.commit()

        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx", 0) //sf에 저장된 userIdx 가져오기

        showLoadingDialog(context!!)
        ReservCheckService(this).tryGetReservCheck(userIdx)

    }

    override fun onGetReservCheckSuccess(response: ReservCheckResponse) {
        dismissLoadingDialog()

        if(response.code == 1000) {

            Log.e(TAG, "onGetReservCheckSuccess: ${response.message}")
            Log.e(TAG, "${response.result}")
            // 예약 확인 조회 성공
            response.message?.let { showCustomToast(it) }

            val result = response.result

            var reservList: List<Result> = result
            binding.reservCheckBeforeRecyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.reservCheckBeforeRecyclerview.setHasFixedSize(true)
            binding.reservCheckBeforeRecyclerview.adapter = reservList?.let { ReservCheckBefoRecycAdapter(it) }
        }
    }

    override fun onGetReservCheckFailure(message: String, response: ReservCheckResponse) {
        dismissLoadingDialog()

        Log.e(TAG, "onGetReservCheckFailure: ${response.message}")
        when(response.code) {

            //jwt토큰 존재 x
            2000 -> {
                showCustomToast("$message")
            }

            //유효하지 않은 status Idx (1,2,3만 적을것!)
            2001 -> {
                showCustomToast("$message")
            }

            //jwt토큰 유효하지 않음
            3000 -> {
                showCustomToast("$message")
            }

            //권한이 없는 유저(userIdx와 jwt의 userIdx불일치)
            3001 -> {
                showCustomToast("$message")
            }


        }
    }

}