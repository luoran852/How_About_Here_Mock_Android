package com.softsquared.template.kotlin.src.main.hotelReserv.model

import com.google.gson.annotations.SerializedName

data class PostReservRequest(

        @SerializedName("checkIn") val checkIn: Int,
        @SerializedName("checkOut") val checkOut: Int,
        @SerializedName("reserverName") val reserverName: String

)
