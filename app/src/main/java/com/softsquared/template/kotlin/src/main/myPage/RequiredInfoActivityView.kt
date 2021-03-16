package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.src.main.home.models.SignUpResponse
import com.softsquared.template.kotlin.src.main.home.models.UserResponse

interface RequiredInfoActivityView {

//    fun onGetUserSuccess(response: UserResponse)
//
//    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String, response: SignUpResponse)

}