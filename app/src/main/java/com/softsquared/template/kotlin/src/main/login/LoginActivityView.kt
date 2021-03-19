package com.softsquared.template.kotlin.src.main.login

import com.softsquared.template.kotlin.src.main.login.model.LoginResponse


interface LoginActivityView {

    fun onPostLoginSuccess(response: LoginResponse)

    fun onPostLoginFailure(message: String, response: LoginResponse)

}