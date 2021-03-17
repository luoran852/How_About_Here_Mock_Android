package com.softsquared.template.kotlin.src.main.required

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.required.model.PostSignUpRequest
import com.softsquared.template.kotlin.src.main.required.model.SignUpResponse
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
        val requiredRetrofitInterface = ApplicationClass.sRetrofit.create(RequiredRetrofitInterface::class.java)
        requiredRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object :
            Callback<SignUpResponse> {
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                view.onPostSignUpSuccess(response.body() as SignUpResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                view.onPostSignUpFailure(t.message ?: "통신 오류", this as SignUpResponse)
            }
        })
    }

}