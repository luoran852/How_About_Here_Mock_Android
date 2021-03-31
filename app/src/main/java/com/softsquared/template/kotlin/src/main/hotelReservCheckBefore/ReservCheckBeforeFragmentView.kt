package com.softsquared.template.kotlin.src.main.hotelReservCheckBefore

import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.model.ReservCheckResponse


interface ReservCheckBeforeFragmentView {

    fun onGetReservCheckSuccess(response: ReservCheckResponse)

    fun onGetReservCheckFailure(message: String, response: ReservCheckResponse)

}