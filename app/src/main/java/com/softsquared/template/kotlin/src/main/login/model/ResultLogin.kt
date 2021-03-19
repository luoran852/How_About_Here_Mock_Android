package com.softsquared.template.kotlin.src.main.login.model

import com.google.gson.annotations.SerializedName

data class ResultLogin(
        @SerializedName("jwt") val jwt: String
)
