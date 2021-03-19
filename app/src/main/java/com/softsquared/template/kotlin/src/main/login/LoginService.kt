package com.softsquared.template.kotlin.src.main.login

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.TAG
import com.softsquared.template.kotlin.src.main.login.model.LoginResponse
import com.softsquared.template.kotlin.src.main.login.model.PostLoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: LoginActivityView) {

    fun tryPostLogin(postLoginRequest: PostLoginRequest) {
        val loginRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        loginRetrofitInterface.postLogin(postLoginRequest).enqueue(object :
                Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                view.onPostLoginSuccess(response.body() as LoginResponse)
                Log.e(ApplicationClass.TAG, "${response.body()}")
                Log.e(TAG, "${response}", )
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e(ApplicationClass.TAG, "LoginEmailService-onFailure")
                view.onPostLoginFailure(t.message ?: "통신 오류", this as LoginResponse)
            }
        })
    }

}