package com.softsquared.template.kotlin.src.main.home.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("guestHouse")
    val guestHouse: List<Any> = listOf(),
    @SerializedName("hotelResort")
    val hotelResort: List<HotelResort> = listOf(),
    @SerializedName("motel")
    val motel: List<Motel> = listOf(),
    @SerializedName("pensionCamping")
    val pensionCamping: List<PensionCamping> = listOf(),
    @SerializedName("viewlist")
    val viewlist: List<Any> = listOf()
)