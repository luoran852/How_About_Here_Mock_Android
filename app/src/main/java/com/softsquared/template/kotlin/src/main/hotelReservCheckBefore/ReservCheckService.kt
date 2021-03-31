package com.softsquared.template.kotlin.src.main.hotelReservCheckBefore

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.model.ReservCheckResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReservCheckService(val view: ReservCheckBeforeFragmentView) {

    fun tryGetReservCheck(userIdx: Int) {
        val getReservCheckRetrofitInterface = ApplicationClass.sRetrofit.create(GetReservCheckRetrofitInterface::class.java)
        getReservCheckRetrofitInterface.getReservCheck(userIdx).enqueue(object :
                Callback<ReservCheckResponse> {
            override fun onResponse(
                    call: Call<ReservCheckResponse>,
                    response: Response<ReservCheckResponse>
            ) {
                Log.e(ApplicationClass.TAG, "onResponse: tryGetReservCheck 성공, ${response.message()}")
                view.onGetReservCheckSuccess(response.body() as ReservCheckResponse)
            }

            override fun onFailure(call: Call<ReservCheckResponse>, t: Throwable) {
                Log.e(ApplicationClass.TAG, "onFailure: tryGetReservCheck 실패, ${t.message}")
                view.onGetReservCheckFailure(t.message ?: "통신 오류", this as ReservCheckResponse)
            }

        })

    }

}