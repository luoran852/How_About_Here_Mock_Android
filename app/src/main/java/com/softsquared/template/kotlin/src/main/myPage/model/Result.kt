package com.softsquared.template.kotlin.src.main.myPage.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("name")
    val name: Int = 0,
    @SerializedName("nickname")
    val nickname: String = "",
    @SerializedName("phone")
    val phone: String = "",
    @SerializedName("profile")
    val profile: String = "",
    @SerializedName("userId")
    val userId: String = "",
    @SerializedName("userIdx")
    val userIdx: Int = 0
)