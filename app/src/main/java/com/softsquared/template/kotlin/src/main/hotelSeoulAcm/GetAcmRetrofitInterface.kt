package com.softsquared.template.kotlin.src.main.hotelSeoulAcm

import com.softsquared.template.kotlin.src.main.hotelSeoulAcm.model.AcmResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetAcmRetrofitInterface {

    @GET("/categories/2/acms/{acmIdx}/rooms/{roomIdx}?checkIn=20210317&checkOut=20210318")
    fun getAcm(
            @Path("acmIdx") acmIdx: Int,
            @Path("roomIdx") roomIdx: Int,
            @Query("checkIn") checkIn: Int?,
            @Query("checkOut") checkOut: Int?
    ): Call<AcmResponse>

}