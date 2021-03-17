package com.softsquared.template.kotlin.src.main.required.model

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest(
    @SerializedName("id") val id: String,
    @SerializedName("pwd") val pwd: String,
    @SerializedName("nickname") val nickname: String
)
