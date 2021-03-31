package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.models.HomeResponse


interface HomeFragmentView {

    fun onGetHomeSuccess(response: HomeResponse)

    fun onGetHomeFailure(message: String, response: HomeResponse)

//    fun onPostSignUpSuccess(response: SignUpResponse)
//
//    fun onPostSignUpFailure(message: String)
}