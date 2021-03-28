package com.softsquared.template.kotlin.src.main.search

import com.softsquared.template.kotlin.src.main.search.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetSearchRetrofitInterface {

    @GET("/categories/0?type=2&keyword=서울&checkIn=20210401&checkOut=20210402&alignIdx=1")
    fun getSearch(
            @Query("keyword") keyword: String?,
            @Query("checkIn") checkIn: Int?,
            @Query("checkOut") checkOut: Int?,
            @Query("alignIdx") alignIdx: Int?
    ): Call<SearchResponse>

}