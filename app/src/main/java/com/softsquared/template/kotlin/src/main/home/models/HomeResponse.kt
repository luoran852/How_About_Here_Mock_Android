package com.softsquared.template.kotlin.src.main.home.models


import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("isSuccess")
    val isSuccess: Boolean = false,
    @SerializedName("message")
    val message: String = "",
    @SerializedName("result")
    val result: List<Result> = listOf()
)