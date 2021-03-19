package com.softsquared.template.kotlin.src.main.kakaoSignUp

import android.os.Bundle
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityKakaoSignupBinding

class KaKaoSignUpActivity : BaseActivity<ActivityKakaoSignupBinding>(ActivityKakaoSignupBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 나가기 버튼
        binding.kakaoSignupBackBtn.setOnClickListener {
            finish()
        }

        // 닉네임 설정 다음 버튼
        binding.kakaoSignupNextBtn.setOnClickListener {


        }

    }

}