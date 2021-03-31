package com.softsquared.template.kotlin.src.main.loginEmail

import android.os.Bundle
import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
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

        //jwt값 sharedpreference에 저장
        Log.e(TAG, "이메일로 로그인 성공, jwt = ${response.result[0]}")

        // SharedPreferences 의 데이터를 저장/편집을 위해 Editor 변수를 선언
        val editor1 = ApplicationClass.sSharedPreferences.edit()

        // key값에 value값을 저장
        editor1.putString(ApplicationClass.X_ACCESS_TOKEN, response.result[0].jwt)

        // 메모리에 있는 데이터를 저장장치에 저장함. commit
        editor1.commit()

        if (response.code == 1000) {
            Log.e(TAG, "onPostLoginEmailSuccess: 로그인 성공")
            response.message?.let { showCustomToast(it) }

            //userIdx값 sharedpreference에 저장
            Log.e(TAG, "이메일로 로그인 성공, userIdx = ${response.result[0].userIdx}")

            // SharedPreferences 의 데이터를 저장/편집을 위해 Editor 변수를 선언
            val editor2 = ApplicationClass.sSharedPreferences.edit()

            // key값에 value값을 저장
            editor2.putInt("userIdx", response.result[0].userIdx)

            // 메모리에 있는 데이터를 저장장치에 저장함. commit
            editor2.commit()

            Log.e(TAG, "userIdx 저장됐는지 확인: ${ApplicationClass.sSharedPreferences.getInt("userIdx", 0)}")

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