package com.softsquared.template.kotlin.src.main.hotelSeoulDetail

import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.HotelDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDetailRetrofitInterface {

    @GET("/categories/1/acms/1?checkIn=20210317&checkOut=20210318")
    fun getHotelDetail(
            @Query("checkIn") checkIn: String?,
            @Query("checkOut") checkOut: String?
    ): Call<HotelDetailResponse>

}