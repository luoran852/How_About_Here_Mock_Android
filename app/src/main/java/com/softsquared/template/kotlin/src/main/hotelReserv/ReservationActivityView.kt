package com.softsquared.template.kotlin.src.main.hotelReserv

import com.softsquared.template.kotlin.src.main.hotelReserv.model.ReservPageResponse


interface ReservationActivityView {

    fun onGetReservPageSuccess(response: ReservPageResponse)

    fun onGetReservPageFailure(message: String, response: ReservPageResponse)

}