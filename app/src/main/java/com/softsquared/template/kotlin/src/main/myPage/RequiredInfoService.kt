package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.home.HomeRetrofitInterface
import com.softsquared.template.kotlin.src.main.home.models.PostSignUpRequest
import com.softsquared.template.kotlin.src.main.home.models.SignUpResponse
import com.softsquared.template.kotlin.src.main.home.models.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequiredInfoService(val view: RequiredInfoActivityView) {

//    fun tryGetUsers(){
//        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
//        homeRetrofitInterface.getUsers().enqueue(object : Callback<UserResponse> {
//            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
//                view.onGetUserSuccess(response.body() as UserResponse)
//            }
//
//            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//                view.onGetUserFailure(t.message ?: "통신 오류")
//            }
//        })
//    }

    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest){
        val myPageRetrofitInterface = ApplicationClass.sRetrofit.create(MyPageRetrofitInterface::class.java)
        myPageRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object :
            Callback<SignUpResponse> {
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {

                when(response.code()) {

                    100 -> {
                        response.body()?.let {

//                            val id = it.
                        }
                    }
                }


                view.onPostSignUpSuccess(response.body() as SignUpResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                view.onPostSignUpFailure(t.message ?: "통신 오류", this as SignUpResponse)
            }
        })
    }

}