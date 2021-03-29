package com.softsquared.template.kotlin.src.main.hotelSeoulAcm.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("acmIdx")
    val acmIdx: Int = 0,
    @SerializedName("categoryIdx")
    val categoryIdx: Int = 0,
    @SerializedName("checkIn")
    val checkIn: String = "",
    @SerializedName("checkOut")
    val checkOut: String = "",
    @SerializedName("facility")
    val facility: String = "",
    @SerializedName("img")
    val img: List<String> = listOf(),
    @SerializedName("info")
    val info: List<String> = listOf(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("night")
    val night: String = "",
    @SerializedName("paymentAmount")
    val paymentAmount: Int = 0,
    @SerializedName("price")
    val price: Int = 0,
    @SerializedName("price2")
    val price2: Int = 0,
    @SerializedName("refund")
    val refund: List<String> = listOf(),
    @SerializedName("roomIdx")
    val roomIdx: Int = 0
)