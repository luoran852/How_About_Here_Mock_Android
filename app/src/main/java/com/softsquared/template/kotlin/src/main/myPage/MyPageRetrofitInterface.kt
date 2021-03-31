package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.src.main.myPage.model.MyPageResponse
import com.softsquared.template.kotlin.src.main.myPage.model.PostMyPageRequest
import com.softsquared.template.kotlin.src.main.myPage.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MyPageRetrofitInterface {

//    @POST("/check-login")
//    fun postMyPage(@Body params: PostMyPageRequest): Call<UserResponse>

    @GET("/users/{userIdx}")
    fun getMyPage(
            @Path("userIdx") userIdx: Int
    ) : Call<MyPageResponse>
}