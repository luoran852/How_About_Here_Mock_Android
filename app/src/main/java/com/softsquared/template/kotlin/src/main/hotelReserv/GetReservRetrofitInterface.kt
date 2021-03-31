package com.softsquared.template.kotlin.src.main.hotelReserv

import com.softsquared.template.kotlin.src.main.hotelReserv.model.PostReservRequest
import com.softsquared.template.kotlin.src.main.hotelReserv.model.ReservPageResponse
import com.softsquared.template.kotlin.src.main.hotelReserv.model.ReservResponse
import retrofit2.Call
import retrofit2.http.*

interface GetReservRetrofitInterface {

    @GET("/categories/2/acms/{acmIdx}/rooms/{roomIdx}/reservation?checkIn=20210401&checkOut=20210402")
    fun getReservPage(
            @Path("acmIdx") acmIdx: Int,
            @Path("roomIdx") roomIdx: Int,
            @Query("checkIn") checkIn: Int?,
            @Query("checkOut") checkOut: Int?
    ): Call<ReservPageResponse>

    @POST("/users/{userIdx}/reservation/acms/{acmIdx}/rooms/{roomIdx}")
    fun postReserv(
            @Body params: PostReservRequest,
            @Path("userIdx") userIdx: Int,
            @Path("acmIdx") acmIdx: Int,
            @Path("roomIdx") roomIdx: Int
    ): Call<ReservResponse>

}