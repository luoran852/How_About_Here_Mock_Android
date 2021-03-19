package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.src.main.myPage.model.PostMyPageRequest
import com.softsquared.template.kotlin.src.main.myPage.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MyPageRetrofitInterface {
//    @GET("/users")
//    fun getUsers() : Call<UserResponse>

    @POST("/check-login")
    fun postMyPage(@Body params: PostMyPageRequest): Call<UserResponse>

}