package com.softsquared.template.kotlin.src.main.myPage.model

import com.google.gson.annotations.SerializedName

data class ResultSignUp(
    @SerializedName("userId") val userId: Int,
    @SerializedName("jwt") val jwt: String
)
