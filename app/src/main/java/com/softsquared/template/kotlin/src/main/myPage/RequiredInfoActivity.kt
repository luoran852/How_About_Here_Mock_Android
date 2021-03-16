package com.softsquared.template.kotlin.src.main.myPage

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.sRetrofit
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityRequiredInfoBinding
import com.softsquared.template.kotlin.src.main.home.models.PostSignUpRequest
import com.softsquared.template.kotlin.src.main.home.models.SignUpResponse
import com.softsquared.template.kotlin.src.main.home.models.UserResponse
import retrofit2.create

class RequiredInfoActivity : BaseActivity<ActivityRequiredInfoBinding>
    (ActivityRequiredInfoBinding::inflate), RequiredInfoActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.requiredInfoBtn.setOnClickListener {
            val id = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val nickname = binding.editNickname.text.toString()
            val phone = findViewById<TextView>(R.id.edit_text_phone).text.toString()
            val postRequest = PostSignUpRequest(id = id, pwd = password,
                nickname = nickname, phone = phone)
            showLoadingDialog(this)
            RequiredInfoService(this).tryPostSignUp(postRequest)
        }

    }

    //post 성공시
    override fun onPostSignUpSuccess(response: SignUpResponse) {
        dismissLoadingDialog()
//        binding.editEmail.text = response.message

        when(response.code){
            1000 -> {
                response.message?.let { showCustomToast(it) }
            }
        }

    }

    //post 실패시
    override fun onPostSignUpFailure(message: String, response: SignUpResponse) {
        dismissLoadingDialog()

        when(response.code){
            //입력사항을 모두 기입해주세요.
            2000 -> {
                showCustomToast("$message")
            }

            //중복된 id입니다.
            3000 -> {
                showCustomToast("$message")
            }

            //중복된 닉네임입니다.
            3001 -> {
                showCustomToast("$message")
            }

            //비밀번호 유효성검사 실패
            3002 -> {
                showCustomToast("$message")
            }

            //id를 이메일 형식으로 입력해주세요
            3003 -> {
                showCustomToast("$message")
            }
        }


    }
}