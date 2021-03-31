package com.softsquared.template.kotlin.src.main.myPage

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageResponse
import com.softsquared.template.kotlin.src.main.myPage.model.PostMyPageRequest
import com.softsquared.template.kotlin.src.main.myPage.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageService(val view: MyPageFragmentView) {

//    //mypage 가져오기
//    fun tryPostMyPage(postMyPageRequest: PostMyPageRequest) {
//        val myPageRetrofitInterface = ApplicationClass.sRetrofit.create(MyPageRetrofitInterface::class.java)
//        myPageRetrofitInterface.postMyPage(postMyPageRequest).enqueue(object :
//                Callback<UserResponse> {
//            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
//                view.onPostMyPageSuccess(response.body() as UserResponse)
//                Log.e(ApplicationClass.TAG, "jwt? ${response.body()}")
//
//            }
//
//            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//                Log.e(ApplicationClass.TAG, "LoginEmailService-onFailure")
//                view.onPostMyPageFailure(t.message ?: "통신 오류", this as UserResponse)
//            }
//        })
//    }

    //로그인 성공시 회원정보 view 띄우기
    fun tryGetMyPage(userIdx : Int) {
        val myPageRetrofitInterface = ApplicationClass.sRetrofit.create(MyPageRetrofitInterface::class.java)
        myPageRetrofitInterface.getMyPage(userIdx).enqueue(object :
                Callback<MyPageResponse> {
            override fun onResponse(
                    call: Call<MyPageResponse>,
                    response: Response<MyPageResponse>
            ) {
                Log.e(ApplicationClass.TAG, "onResponse: tryGetMyPage 성공, ${response.message()}")
                view.onGetMyPageSuccess(response.body() as MyPageResponse)
            }

            override fun onFailure(call: Call<MyPageResponse>, t: Throwable) {
                Log.e(ApplicationClass.TAG, "onFailure: tryGetMyPage 실패, ${t.message}")
                view.onGetMyPageFailure(t.message ?: "통신 오류", this as MyPageResponse)
            }

        })

    }


}