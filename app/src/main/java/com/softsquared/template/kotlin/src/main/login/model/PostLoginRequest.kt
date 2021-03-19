package com.softsquared.template.kotlin.src.main.login.model

import com.google.gson.annotations.SerializedName

data class PostLoginRequest (
        @SerializedName("TOKEN") val TOKEN: String
        )