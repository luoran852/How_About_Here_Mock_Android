package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.src.main.home.models.PostSignUpRequest
import com.softsquared.template.kotlin.src.main.home.models.SignUpResponse
import com.softsquared.template.kotlin.src.main.home.models.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MyPageRetrofitInterface {
    @GET("/users")
    fun getUsers() : Call<UserResponse>

    @POST("/sign-up")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>
}