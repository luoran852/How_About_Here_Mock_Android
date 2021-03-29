package com.softsquared.template.kotlin.src.main.hotelSeoulDetail

import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.HotelDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetDetailRetrofitInterface {

    @GET("/categories/2/acms/{acmIdx}?checkIn=20210401&checkOut=20210402")
    fun getHotelDetail(
            @Path("acmIdx") acmIdx: Int,
            @Query("checkIn") checkIn: Int?,
            @Query("checkOut") checkOut: Int?
    ): Call<HotelDetailResponse>

}