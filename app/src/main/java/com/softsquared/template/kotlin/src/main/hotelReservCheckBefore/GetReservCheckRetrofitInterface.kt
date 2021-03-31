package com.softsquared.template.kotlin.src.main.hotelReservCheckBefore

import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.model.ReservCheckResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GetReservCheckRetrofitInterface {

    @GET("/users/{userIdx}/reservations/status/1")
    fun getReservCheck(
            @Path("userIdx") userIdx: Int
    ): Call<ReservCheckResponse>

}