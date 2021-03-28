package com.softsquared.template.kotlin.src.main.search.model


import com.google.gson.annotations.SerializedName

data class Result(
        @SerializedName("acmIdx")
        val acmIdx: Int = 0,
        @SerializedName("img")
        val img: String = "",
        @SerializedName("location")
        val location: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("price")
        val price: Int = 0,
        @SerializedName("rating")
        val rating: List<String> = listOf(),
        @SerializedName("reviewAverage")
        val reviewAverage: Double = 0.0,
        @SerializedName("reviewCnt")
        val reviewCnt: Int = 0,
        @SerializedName("surround")
        val surround: String? = null
)