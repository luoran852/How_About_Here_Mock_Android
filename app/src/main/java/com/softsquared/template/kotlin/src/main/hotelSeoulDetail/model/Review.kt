package com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model


import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("content")
    val content: String = "",
    @SerializedName("createdAt")
    val createdAt: String = "",
    @SerializedName("grade")
    val grade: Int = 0,
    @SerializedName("img")
    val img: List<String> = listOf(),
    @SerializedName("likeCnt")
    val likeCnt: Int = 0,
    @SerializedName("likeStatus")
    val likeStatus: Int = 0,
    @SerializedName("nickname")
    val nickname: String = "",
    @SerializedName("profile")
    val profile: String = "",
    @SerializedName("reviewIdx")
    val reviewIdx: Int = 0,
    @SerializedName("roomName")
    val roomName: String = ""
)