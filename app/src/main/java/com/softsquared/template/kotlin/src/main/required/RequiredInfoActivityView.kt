package com.softsquared.template.kotlin.src.main.required

import com.softsquared.template.kotlin.src.main.required.model.SignUpResponse

interface RequiredInfoActivityView {

//    fun onGetUserSuccess(response: UserResponse)
//
//    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String, response: SignUpResponse)

}