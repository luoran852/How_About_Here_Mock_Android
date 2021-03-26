package com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model

data class Result(
    val acmIdx: Int = 0, // 0
    val categoryIdx: Int = 0, // 1
    val checkIn: String = "", // 2
    val checkOut: String = "", // 3
    val facility: List<String> = listOf(), // 4
    val img: List<String> = listOf(), // 5
    val info: List<String> = listOf(), // 6
    val intro: String = "", // 7
    val likeStatus: Int = 0, // 8
    val location: String = "", // 9
    val name: String = "", // 10
    val night: String = "", // 11
    val notice: List<String> = listOf(), // 12
    val rating: List<String> = listOf(), // 13
    val refund: List<String> = listOf(), // 14
    val reviewAverage: Double = 0.0, // 15
    val reviewCnt: Int = 0, // 16
    val reviews: List<Review> = listOf(), // 17
    val rooms: List<Room> = listOf() // 18
)