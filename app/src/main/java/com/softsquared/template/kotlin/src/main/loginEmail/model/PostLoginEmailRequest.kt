package com.softsquared.template.kotlin.src.main.loginEmail.model

import com.google.gson.annotations.SerializedName

data class PostLoginEmailRequest(
        @SerializedName("id") val id: String,
        @SerializedName("pwd") val pwd: String
)
