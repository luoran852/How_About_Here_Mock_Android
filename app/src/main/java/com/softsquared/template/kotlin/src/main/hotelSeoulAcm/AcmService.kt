package com.softsquared.template.kotlin.src.main.hotelSeoulAcm

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.hotelSeoulAcm.model.AcmResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AcmService(val view: HotelSeoulAcmActivityView) {

    fun tryGetAcm(acmIdx : Int, roomIdx : Int, checkIn : Int, checkOut : Int) {
        val getDetailRetrofitInterface = ApplicationClass.sRetrofit.create(GetAcmRetrofitInterface::class.java)
        getDetailRetrofitInterface.getAcm(acmIdx, roomIdx, checkIn, checkOut).enqueue(object :
                Callback<AcmResponse> {
            override fun onResponse(
                    call: Call<AcmResponse>,
                    response: Response<AcmResponse>
            ) {
                Log.e(ApplicationClass.TAG, "onResponse: tryGetHotelDetail 성공, ${response.message()}")
                view.onGetAcmSuccess(response.body() as AcmResponse)
            }

            override fun onFailure(call: Call<AcmResponse>, t: Throwable) {
                Log.e(ApplicationClass.TAG, "onFailure: tryGetHotelDetail 실패, ${t.message}")
                view.onGetAcmFailure(t.message ?: "통신 오류", this as AcmResponse)
            }

        })

    }

}