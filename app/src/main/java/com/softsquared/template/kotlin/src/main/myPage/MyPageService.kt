package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.myPage.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageService(val view: MyPageFragmentView) {

//    fun tryGetUsers(){
//        val MyPageRetrofitInterface = ApplicationClass.sRetrofit.create(MyPageRetrofitInterface::class.java)
//        MyPageRetrofitInterface.getUsers().enqueue(object : Callback<UserResponse> {
//            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
//                view.onGetUserSuccess(response.body() as UserResponse)
//            }
//
//            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//                view.onGetUserFailure(t.message ?: "통신 오류")
//            }
//        })
//    }



}