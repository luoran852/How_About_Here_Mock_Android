package com.softsquared.template.kotlin.src.main.hotelReserv

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.hotelReserv.model.PostReservRequest
import com.softsquared.template.kotlin.src.main.hotelReserv.model.ReservPageResponse
import com.softsquared.template.kotlin.src.main.hotelReserv.model.ReservResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReservService(val view: ReservationActivityView) {

    //예약 page
    fun tryGetReservPage(acmIdx : Int, roomIdx : Int, checkIn : Int, checkOut : Int) {

        val getReservRetrofitInterface = ApplicationClass.sRetrofit.create(GetReservRetrofitInterface::class.java)

        getReservRetrofitInterface.getReservPage(acmIdx, roomIdx, checkIn, checkOut).enqueue(object :
                Callback<ReservPageResponse> {
            override fun onResponse(call: Call<ReservPageResponse>, response: Response<ReservPageResponse>) {
                Log.e(ApplicationClass.TAG, "onResponse: tryGetReservPage 성공, ${response.message()}")
                view.onGetReservPageSuccess(response.body() as ReservPageResponse)
            }

            override fun onFailure(call: Call<ReservPageResponse>, t: Throwable) {
                Log.e(ApplicationClass.TAG, "onFailure: tryGetReservPage 실패, ${t.message}")
                view.onGetReservPageFailure(t.message ?: "통신 오류", this as ReservPageResponse)
            }

        })

    }

    //예약하기
    fun tryPostReserv(postReservRequest: PostReservRequest, userIdx: Int, acmIdx: Int, roomIdx: Int) {

        val getReservRetrofitInterface = ApplicationClass.sRetrofit.create(GetReservRetrofitInterface::class.java)

        getReservRetrofitInterface.postReserv(postReservRequest, userIdx, acmIdx, roomIdx).enqueue(object :
                Callback<ReservResponse> {

            override fun onResponse(call: Call<ReservResponse>, response: Response<ReservResponse>) {
                Log.e(ApplicationClass.TAG, "onResponse: tryPostReserv 성공, ${response.message()}")
                view.onPostReservSuccess(response.body() as ReservResponse)
            }

            override fun onFailure(call: Call<ReservResponse>, t: Throwable) {
                Log.e(ApplicationClass.TAG, "onFailure: tryPostReserv 실패, ${t.message}")
                view.onPostReservFailure(t.message ?: "통신 오류", this as ReservResponse)
            }

        })
    }
}