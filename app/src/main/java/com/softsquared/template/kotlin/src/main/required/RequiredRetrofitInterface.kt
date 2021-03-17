package com.softsquared.template.kotlin.src.main.required

import com.softsquared.template.kotlin.src.main.required.model.PostSignUpRequest
import com.softsquared.template.kotlin.src.main.required.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequiredRetrofitInterface {

    @POST("/sign-up")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>

}