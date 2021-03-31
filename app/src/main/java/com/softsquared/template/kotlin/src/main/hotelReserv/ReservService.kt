package com.softsquared.template.kotlin.src.main.hotelReserv

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.hotelReserv.model.ReservPageResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReservService(val view: ReservationActivityView) {

    //예약 page
    fun tryGetReservPage(acmIdx : Int, roomIdx : Int, checkIn : Int, checkOut : Int) {

        val getReservRetrofitInterface = ApplicationClass.sRetrofit.create(GetReservRetrofitInterface::class.java)

        //예약 page
        getReservRetrofitInterface.getReservPage(acmIdx, roomIdx, checkIn, checkOut).enqueue(object :
                Callback<ReservPageResponse> {
            override fun onResponse(
                    call: Call<ReservPageResponse>,
                    response: Response<ReservPageResponse>
            ) {
                Log.e(ApplicationClass.TAG, "onResponse: tryGetReservPage 성공, ${response.message()}")
                view.onGetReservPageSuccess(response.body() as ReservPageResponse)
            }

            override fun onFailure(call: Call<ReservPageResponse>, t: Throwable) {
                Log.e(ApplicationClass.TAG, "onFailure: tryGetReservPage 실패, ${t.message}")
                view.onGetReservPageFailure(t.message ?: "통신 오류", this as ReservPageResponse)
            }

        })

        //예약하기


    }
}