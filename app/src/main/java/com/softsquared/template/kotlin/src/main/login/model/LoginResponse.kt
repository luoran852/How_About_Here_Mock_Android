package com.softsquared.template.kotlin.src.main.login.model

import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseResponse

data class LoginResponse(
        @SerializedName("result") val result: ArrayList<ResultLogin>
//    @SerializedName("isSuccess") val isSuccess: Boolean,
//    @SerializedName("code") val code: Int,
//    @SerializedName("message") val message: String
) : BaseResponse()