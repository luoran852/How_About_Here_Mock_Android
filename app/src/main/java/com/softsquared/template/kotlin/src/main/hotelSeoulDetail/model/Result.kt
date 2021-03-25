package com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model


import com.google.gson.annotations.SerializedName

data class Result(
        @SerializedName("acmIdx")
    val acmIdx: Int = 0, // 0
        @SerializedName("categoryIdx")
    val categoryIdx: Int = 0, // 1
        @SerializedName("checkIn")
    val checkIn: String = "", // 2
        @SerializedName("checkOut")
    val checkOut: String = "", // 3
        @SerializedName("facility")
    val facility: List<String> = listOf(), // 4
        @SerializedName("img")
    val img: List<String> = listOf(), // 5
        @SerializedName("info")
    val info: List<String> = listOf(), // 6
        @SerializedName("intro")
    val intro: String = "", // 7
        @SerializedName("likeStatus")
    val likeStatus: Int = 0, // 8
        @SerializedName("location")
    val location: String = "", // 9
        @SerializedName("name")
    val name: String = "", // 10
        @SerializedName("night")
    val night: String = "", // 11
        @SerializedName("notice")
    val notice: List<String> = listOf(), // 12
        @SerializedName("rating")
    val rating: List<String> = listOf(), // 13
        @SerializedName("refund")
    val refund: List<String> = listOf(), // 14
        @SerializedName("reviewAverage")
    val reviewAverage: Double = 0.0, // 15
        @SerializedName("reviewCnt")
    val reviewCnt: Int = 0, // 16
        @SerializedName("reviews")
    val reviews: List<Review> = listOf(), // 17
        @SerializedName("rooms")
    val rooms: List<Room> = listOf() // 18
)