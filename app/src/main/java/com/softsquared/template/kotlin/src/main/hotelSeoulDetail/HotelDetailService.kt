package com.softsquared.template.kotlin.src.main.hotelSeoulDetail

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.HotelDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HotelDetailService(val view: HotelSeoulDetailActivityView) {

    fun tryGetHotelDetail(checkIn : String, checkOut : String) {
        val getDetailRetrofitInterface = ApplicationClass.sRetrofit.create(GetDetailRetrofitInterface::class.java)
        getDetailRetrofitInterface.getHotelDetail(checkIn, checkOut).enqueue(object : Callback<HotelDetailResponse> {
            override fun onResponse(call: Call<HotelDetailResponse>, response: Response<HotelDetailResponse>) {
                view.onGetHotelDetailSuccess(response.body() as HotelDetailResponse)
            }

            override fun onFailure(call: Call<HotelDetailResponse>, t: Throwable) {
                view.onGetHotelDetailFailure(t.message ?: "통신 오류", this as HotelDetailResponse)
            }

        })

    }

}