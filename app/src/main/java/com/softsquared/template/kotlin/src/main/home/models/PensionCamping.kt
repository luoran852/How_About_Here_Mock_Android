package com.softsquared.template.kotlin.src.main.home.models


import com.google.gson.annotations.SerializedName

data class PensionCamping(
    @SerializedName("acmIdx")
    val acmIdx: Int = 0,
    @SerializedName("categoryIdx")
    val categoryIdx: Int = 0,
    @SerializedName("img")
    val img: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("price")
    val price: Int = 0,
    @SerializedName("price2")
    val price2: Int = 0,
    @SerializedName("reviewAverage")
    val reviewAverage: Int = 0,
    @SerializedName("reviewCnt")
    val reviewCnt: Int = 0,
    @SerializedName("surround")
    val surround: String = ""
)