package com.softsquared.template.kotlin.src.main.login

import com.softsquared.template.kotlin.src.main.login.model.LoginResponse
import com.softsquared.template.kotlin.src.main.login.model.PostLoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {

    @POST("/kakao-login")
    fun postLogin(@Body params: PostLoginRequest): Call<LoginResponse>

}