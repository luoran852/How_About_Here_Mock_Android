package com.softsquared.template.kotlin.src.main.hotelReserv.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("acmIdx")
    val acmIdx: Int = 0,
    @SerializedName("acmName")
    val acmName: String = "",
    @SerializedName("categoryIdx")
    val categoryIdx: Int = 0,
    @SerializedName("checkIn")
    val checkIn: String = "",
    @SerializedName("checkInTime")
    val checkInTime: String = "",
    @SerializedName("checkOut")
    val checkOut: String = "",
    @SerializedName("checkOutTime")
    val checkOutTime: String = "",
    @SerializedName("night")
    val night: String = "",
    @SerializedName("paymentAmount")
    val paymentAmount: Int = 0,
    @SerializedName("reserverName")
    val reserverName: Int = 0,
    @SerializedName("reserverPhone")
    val reserverPhone: String = "",
    @SerializedName("roomIdx")
    val roomIdx: Int = 0,
    @SerializedName("roomInfo")
    val roomInfo: String = "",
    @SerializedName("roomName")
    val roomName: String = ""
)