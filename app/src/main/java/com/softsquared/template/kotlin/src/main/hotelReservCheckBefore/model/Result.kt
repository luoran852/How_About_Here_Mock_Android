package com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.model


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
    @SerializedName("checkInString")
    val checkInString: String = "",
    @SerializedName("checkOut")
    val checkOut: String = "",
    @SerializedName("checkOutString")
    val checkOutString: String = "",
    @SerializedName("img")
    val img: String = "",
    @SerializedName("location")
    val location: String = "",
    @SerializedName("remainTime")
    val remainTime: String = "",
    @SerializedName("reserveNum")
    val reserveNum: Int = 0,
    @SerializedName("roomIdx")
    val roomIdx: Int = 0,
    @SerializedName("roomName")
    val roomName: String = ""
)