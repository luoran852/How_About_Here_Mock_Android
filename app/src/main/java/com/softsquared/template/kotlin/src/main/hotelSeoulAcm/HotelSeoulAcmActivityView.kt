package com.softsquared.template.kotlin.src.main.hotelSeoulAcm

import com.softsquared.template.kotlin.src.main.hotelSeoulAcm.model.AcmResponse


interface HotelSeoulAcmActivityView {

    fun onGetAcmSuccess(response: AcmResponse)

    fun onGetAcmFailure(message: String, response: AcmResponse)

}