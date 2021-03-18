package com.softsquared.template.kotlin.src.main.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLoginBinding
import com.softsquared.template.kotlin.src.main.Agreement.AgreementActivity
import com.softsquared.template.kotlin.src.main.loginEmail.LoginEmailActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private var mCount = 0
    val TAG : String = "태그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 나가기 버튼
        binding.loginOutBtn.setOnClickListener {
            finish()
        }

        // 카카오톡으로 로그인
        binding.kakaoLoginBtn.setOnClickListener {

            // 로그인 공통 callback 구성
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    Log.e(TAG, "로그인 실패", error)

                    when {
                        error.toString() == AuthErrorCause.AccessDenied.toString() -> {
                            Log.e(TAG, "접근이 거부 됨(동의 취소)", error)
                        }
                        error.toString() == AuthErrorCause.InvalidClient.toString() -> {
                            Log.e(TAG, "유효하지 않은 앱", error)
                        }
                        error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
                            Log.e(TAG, "인증 수단이 유효하지 않아 인증할 수 없는 상태", error)
                        }
                        error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
                            Log.e(TAG, "요청 파라미터 오류", error)
                        }
                        error.toString() == AuthErrorCause.InvalidScope.toString() -> {
                            Log.e(TAG, "유효하지 않은 scope ID", error)
                        }
                        error.toString() == AuthErrorCause.Misconfigured.toString() -> {
                            Log.e(TAG, "설정이 올바르지 않음(android key hash)", error)
                        }
                        error.toString() == AuthErrorCause.ServerError.toString() -> {
                            Log.e(TAG, "서버 내부 에러", error)
                        }
                        error.toString() == AuthErrorCause.Unauthorized.toString() -> {
                            Log.e(TAG, "앱이 요청 권한이 없음", error)
                        }
                        else -> { // Unknown
                            showCustomToast("기타 에러")
                        }
                    }

                }
                else if (token != null) {
                    Log.i(TAG, "로그인 성공 ${token.accessToken}")

                }
            }

            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
                UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }

            // 토큰 정보 보기
            UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
                if (error != null) {
                    Log.e(TAG, "토큰 정보 보기 실패", error)
                }
                else if (tokenInfo != null) {
                    Log.i(TAG, "토큰 정보 보기 성공" +
                            "\n회원번호: ${tokenInfo.id}" +
                            "\n만료시간: ${tokenInfo.expiresIn} 초")
                }
            }

        }

        // 이메일로 로그인
        binding.emailLoginBtn.setOnClickListener {
            val intent = Intent(this, LoginEmailActivity::class.java)
            startActivity(intent)
        }

        binding.signUpEmail.setOnClickListener {
            val intent = Intent(this, AgreementActivity::class.java)
            startActivity(intent)
        }
    }
}