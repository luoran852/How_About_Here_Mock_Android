package com.softsquared.template.kotlin.src.main.home

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.home.models.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val view: HomeFragmentView) {

    fun tryGetHome() {

        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(
            HomeRetrofitInterface::class.java)

        homeRetrofitInterface.getHome().enqueue(object : Callback<HomeResponse> {
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                Log.e(ApplicationClass.TAG, "onResponse: tryGetReservPage 성공, ${response.message()}")
                view.onGetHomeSuccess(response.body() as HomeResponse)
            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                Log.e(ApplicationClass.TAG, "onFailure: tryGetReservPage 실패, ${t.message}")
                view.onGetHomeFailure(t.message ?: "통신 오류", this as HomeResponse)
            }

        })

    }

}
