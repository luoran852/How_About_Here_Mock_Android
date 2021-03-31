package com.softsquared.template.kotlin.src.main.required

import android.os.Bundle
import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityRequiredInfoBinding
import com.softsquared.template.kotlin.src.main.required.model.PostSignUpRequest
import com.softsquared.template.kotlin.src.main.required.model.SignUpResponse

class RequiredInfoActivity : BaseActivity<ActivityRequiredInfoBinding>
    (ActivityRequiredInfoBinding::inflate), RequiredInfoActivityView {

    val TAG : String = "태그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 나가기 버튼
        binding.requiredBackBtn.setOnClickListener {
            finish()
        }

        binding.requiredNextBtn.setOnClickListener {
            val id = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val nickname = binding.editNickname.text.toString()
//            val phone = findViewById<TextView>(R.id.edit_text_phone).text.toString()
            val postRequest = PostSignUpRequest(id = id, pwd = password,
                nickname = nickname)
            showLoadingDialog(this)
            RequiredInfoService(this).tryPostSignUp(postRequest)
        }

    }

    //post 성공시
    override fun onPostSignUpSuccess(response: SignUpResponse) {
        dismissLoadingDialog()
//        binding.editEmail.text = response.message

        if (response.code == 1000) {
            Log.e(TAG, "onPostSignUpSuccess: 회원가입 성공")
            response.message?.let { showCustomToast(it) }

            Log.e(TAG, "회원가입 성공, userIdx = ${response.result[0].userIdx}")

            // SharedPreferences 의 데이터를 저장/편집을 위해 Editor 변수를 선언
            val editor = ApplicationClass.sSharedPreferences.edit()

            // key값에 value값을 저장
            editor.putInt("userIdx", response.result[0].userIdx)

            // 메모리에 있는 데이터를 저장장치에 저장함. commit
            editor.commit()

            Log.e(TAG, "userIdx 저장됐는지 확인: ${ApplicationClass.sSharedPreferences.getInt("userIdx", 0)}")

            finish()
        }

    }

    //post 실패시
    override fun onPostSignUpFailure(message: String, response: SignUpResponse) {
        dismissLoadingDialog()

        when(response.code) {

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