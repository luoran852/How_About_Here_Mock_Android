package com.softsquared.template.kotlin.src.main.myPage

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.myPage.model.PostMyPageRequest
import com.softsquared.template.kotlin.src.main.myPage.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageService(val view: MyPageFragmentView) {

    fun tryPostMyPage(postMyPageRequest: PostMyPageRequest) {
        val loginEmailRetrofitInterface = ApplicationClass.sRetrofit.create(MyPageRetrofitInterface::class.java)
        loginEmailRetrofitInterface.postMyPage(postMyPageRequest).enqueue(object :
                Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                view.onPostMyPageSuccess(response.body() as UserResponse)
                Log.e(ApplicationClass.TAG, "jwt? ${response.body()}")

            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e(ApplicationClass.TAG, "LoginEmailService-onFailure")
                view.onPostMyPageFailure(t.message ?: "통신 오류", this as UserResponse)
            }
        })
    }



}