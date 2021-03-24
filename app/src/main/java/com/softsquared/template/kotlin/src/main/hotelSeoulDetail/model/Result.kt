package com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model


import com.google.gson.annotations.SerializedName

data class Result(
        @SerializedName("checkIn")
        val checkIn: String = "",
        @SerializedName("checkOut")
        val checkOut: String = "",
        @SerializedName("facility")
        val facility: List<String> = listOf(),
        @SerializedName("img")
        val img: List<String> = listOf(),
        @SerializedName("info")
        val info: List<String> = listOf(),
        @SerializedName("likeStatus")
        val likeStatus: Int = 0,
        @SerializedName("location")
        val location: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("night")
        val night: String = "",
        @SerializedName("notice")
        val notice: List<String> = listOf(),
        @SerializedName("rating")
        val rating: List<String> = listOf(),
        @SerializedName("refund")
        val refund: List<String> = listOf(),
        @SerializedName("reviewAverage")
        val reviewAverage: Double = 0.0,
        @SerializedName("reviewCnt")
        val reviewCnt: Int = 0,
        @SerializedName("reviews")
        val reviews: List<Review> = listOf(),
        @SerializedName("rooms")
        val rooms: List<Room> = listOf()
)