package com.softsquared.template.kotlin.src.main.myPage

interface MyPageFragmentView {

    fun onGetUserSuccess(response: com.softsquared.template.kotlin.src.main.myPage.model.UserResponse)

    fun onGetUserFailure(message: String)

//    fun onPostSignUpSuccess(response: SignUpResponse)
//
//    fun onPostSignUpFailure(message: String)

}