package com.softsquared.template.kotlin.src.main.loginEmail

import com.softsquared.template.kotlin.src.main.loginEmail.model.LoginEmailResponse
import com.softsquared.template.kotlin.src.main.loginEmail.model.PostLoginEmailRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginEmailRetrofitInterface {

    @POST("/login")
    fun postLoginEmail(@Body params: PostLoginEmailRequest): Call<LoginEmailResponse>

}