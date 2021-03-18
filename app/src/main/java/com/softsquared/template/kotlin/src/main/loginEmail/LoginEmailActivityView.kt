package com.softsquared.template.kotlin.src.main.loginEmail

import com.softsquared.template.kotlin.src.main.loginEmail.model.LoginEmailResponse

interface LoginEmailActivityView {

    fun onPostLoginEmailSuccess(response: LoginEmailResponse)

    fun onPostLoginEmailFailure(message: String, response: LoginEmailResponse)

}