package com.softsquared.template.kotlin.src.main.hotelReserv

import com.softsquared.template.kotlin.src.main.hotelReserv.model.ReservPageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetReservRetrofitInterface {

    @GET("/categories/2/acms/{acmIdx}/rooms/{roomIdx}/reservation?checkIn=20210401&checkOut=20210402")
    fun getReservPage(
            @Path("acmIdx") acmIdx: Int,
            @Path("roomIdx") roomIdx: Int,
            @Query("checkIn") checkIn: Int?,
            @Query("checkOut") checkOut: Int?
    ): Call<ReservPageResponse>

}