package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.models.HomeResponse
import retrofit2.Call
import retrofit2.http.*

interface HomeRetrofitInterface {

    @GET("/home")
    fun getHome() : Call<HomeResponse>

//    @GET("/users")
//    fun getUsers() : Call<UserResponse>

//    @POST("/users")
//    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>

    //사용자 검색할 때 쓰는 interface(템플릿 영상 참조)
//    @GET("/users")
//    fun getUserSearch(@Query("word") word : String) : Call<UserSearchResponse>
}
