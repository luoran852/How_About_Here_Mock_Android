package com.softsquared.template.kotlin.src.main.myPage.model

import com.google.gson.annotations.SerializedName

data class ResultUser(
    @SerializedName("userId") val userId: Int,
    @SerializedName("email") val email: String
)
