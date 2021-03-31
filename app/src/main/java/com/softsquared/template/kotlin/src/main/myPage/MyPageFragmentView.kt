package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.src.main.myPage.model.MyPageResponse
import com.softsquared.template.kotlin.src.main.myPage.model.UserResponse


interface MyPageFragmentView {

//    fun onPostMyPageSuccess(response: UserResponse)
//
//    fun onPostMyPageFailure(message: String, response: UserResponse)

    fun onGetMyPageSuccess(response: MyPageResponse)

    fun onGetMyPageFailure(message: String, response: MyPageResponse)

}