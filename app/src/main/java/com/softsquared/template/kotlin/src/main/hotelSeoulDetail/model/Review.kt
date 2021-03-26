package com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model

data class Review(
    val content: String = "",
    val createdAt: String = "",
    val grade: Int = 0,
    val img: List<String> = listOf(),
    val likeCnt: Int = 0,
    val likeStatus: Int = 0,
    val nickname: String = "",
    val profile: String = "",
    val reviewIdx: Int = 0,
    val roomName: String = ""
)