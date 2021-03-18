package com.softsquared.template.kotlin.src.main.loginEmail.model

import com.google.gson.annotations.SerializedName

data class ResultLoginEmail(
        @SerializedName("jwt") val jwt: String
)
