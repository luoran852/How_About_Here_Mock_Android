package com.softsquared.template.kotlin.src.main.hotelReserv

import com.softsquared.template.kotlin.src.main.hotelReserv.model.ReservPageResponse
import com.softsquared.template.kotlin.src.main.hotelReserv.model.ReservResponse


interface ReservationActivityView {

    fun onGetReservPageSuccess(response: ReservPageResponse)

    fun onGetReservPageFailure(message: String, response: ReservPageResponse)

    fun onPostReservSuccess(response: ReservResponse)

    fun onPostReservFailure(message: String, response: ReservResponse)

}