package com.softsquared.template.kotlin.src.main.myPage.model

import com.google.gson.annotations.SerializedName

data class PostMyPageRequest (
        //JWT
        @SerializedName("X-ACCESS-TOKEN") val XACCESSTOKEN: String?
        )