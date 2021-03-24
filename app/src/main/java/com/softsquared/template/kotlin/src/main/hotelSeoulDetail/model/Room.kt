package com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model


import com.google.gson.annotations.SerializedName

data class Room(
        @SerializedName("img")
        val img: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("price")
        val price: Int = 0,
        @SerializedName("roomIdx")
        val roomIdx: Int = 0,
        @SerializedName("roomInfo")
        val roomInfo: String = ""
)