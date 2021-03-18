package com.softsquared.template.kotlin.src.main.loginEmail

import android.os.Bundle
import android.util.Log
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLoginEmailBinding
import com.softsquared.template.kotlin.src.main.loginEmail.model.LoginEmailResponse
import com.softsquared.template.kotlin.src.main.loginEmail.model.PostLoginEmailRequest

class LoginEmailActivity : BaseActivity<ActivityLoginEmailBinding>(ActivityLoginEmailBinding::inflate),
        LoginEmailActivityView {

    val TAG : String = "태그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 나가기 버튼
        binding.emailLoginBackBtn.setOnClickListener {
            finish()
        }

        //이메일로 로그인 버튼
        binding.loginEmailBtn.setOnClickListener {
            val id = binding.loginEmailEdtEmail.text.toString()
            val password = binding.loginEmailEditPwd.text.toString()

            val postRequest = PostLoginEmailRequest(id = id, pwd = password)
            showLoadingDialog(this)
            LoginEmailService(this).tryPostLoginEmail(postRequest)
        }

    }

    //post 성공시
    override fun onPostLoginEmailSuccess(response: LoginEmailResponse) {
        dismissLoadingDialog()

        if (response.code == 1000) {
            Log.e(TAG, "onPostLoginEmailSuccess: 로그인 성공")
            response.message?.let { showCustomToast(it) }
            finish()
        }
    }

    //post 실패시
    override fun onPostLoginEmailFailure(message: String, response: LoginEmailResponse) {
        dismissLoadingDialog()
        Log.e(TAG, "onPostLoginEmailFailure: 로그인 실패")
        when(response.code) {

            //미입력값 존재
            2000 -> {
                showCustomToast("$message")
            }

            //유효하지 않은 아이디 또는 비밀번호
            3000 -> {
                showCustomToast("$message")
            }

        }
    }


}