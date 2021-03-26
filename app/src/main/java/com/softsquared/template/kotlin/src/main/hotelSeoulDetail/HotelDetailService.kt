package com.softsquared.template.kotlin.src.main.hotelSeoulDetail

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.TAG
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.HotelDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HotelDetailService(val view: HotelSeoulDetailActivityView) {

    fun tryGetHotelDetail(checkIn : Int, checkOut : Int) {
        val getDetailRetrofitInterface = ApplicationClass.sRetrofit.create(GetDetailRetrofitInterface::class.java)
        getDetailRetrofitInterface.getHotelDetail(checkIn, checkOut).enqueue(object :
            Callback<HotelDetailResponse> {
            override fun onResponse(
                call: Call<HotelDetailResponse>,
                response: Response<HotelDetailResponse>
            ) {
                Log.e(TAG, "onResponse: tryGetHotelDetail 성공, ${response.message()}")
                view.onGetHotelDetailSuccess(response.body() as HotelDetailResponse)
            }

            override fun onFailure(call: Call<HotelDetailResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: tryGetHotelDetail 실패, ${t.message}")
                view.onGetHotelDetailFailure(t.message ?: "통신 오류", this as HotelDetailResponse)
            }

        })

    }

}