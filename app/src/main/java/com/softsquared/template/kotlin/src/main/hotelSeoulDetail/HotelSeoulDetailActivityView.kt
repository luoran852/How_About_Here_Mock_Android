package com.softsquared.template.kotlin.src.main.hotelSeoulDetail

import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.HotelDetailResponse

interface HotelSeoulDetailActivityView {

    fun onGetHotelDetailSuccess(response: HotelDetailResponse)

    fun onGetHotelDetailFailure(message: String, response: HotelDetailResponse)
}