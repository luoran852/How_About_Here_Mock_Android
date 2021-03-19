package com.softsquared.template.kotlin.src.main.loginEmail

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.TAG
import com.softsquared.template.kotlin.src.main.loginEmail.model.LoginEmailResponse
import com.softsquared.template.kotlin.src.main.loginEmail.model.PostLoginEmailRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginEmailService(val view: LoginEmailActivityView) {

    fun tryPostLoginEmail(postLoginEmailRequest: PostLoginEmailRequest) {
        val loginEmailRetrofitInterface = ApplicationClass.sRetrofit.create(LoginEmailRetrofitInterface::class.java)
        loginEmailRetrofitInterface.postLoginEmail(postLoginEmailRequest).enqueue(object :
                Callback<LoginEmailResponse> {
            override fun onResponse(call: Call<LoginEmailResponse>, response: Response<LoginEmailResponse>) {
                view.onPostLoginEmailSuccess(response.body() as LoginEmailResponse)
                Log.e(TAG, "jwt? ${response.body()}")

            }

            override fun onFailure(call: Call<LoginEmailResponse>, t: Throwable) {
                Log.e(TAG, "LoginEmailService-onFailure")
                view.onPostLoginEmailFailure(t.message ?: "통신 오류", this as LoginEmailResponse)
            }
        })
    }

}