package com.softsquared.template.kotlin.src.main.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.sSharedPreferences
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLoginBinding
import com.softsquared.template.kotlin.src.main.login.model.LoginResponse
import com.softsquared.template.kotlin.src.main.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.main.loginEmail.LoginEmailActivity
import com.softsquared.template.kotlin.src.main.myPage.MyPageFragment
import com.softsquared.template.kotlin.src.main.myPage.MyPageService
import com.softsquared.template.kotlin.src.main.required.RequiredInfoActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate),
    LoginActivityView {

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

                    val TOKEN = token.accessToken

                    val postRequest = PostLoginRequest(TOKEN = TOKEN)
                    showLoadingDialog(this)
                    LoginService(this).tryPostLogin(postRequest)
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
            val intent = Intent(this, RequiredInfoActivity::class.java)
            startActivity(intent)
        }
    }

    //post 성공시
    override fun onPostLoginSuccess(response: LoginResponse) {
        dismissLoadingDialog()

        //jwt값 sharedpreference에 저장
        Log.e(TAG, "카카오톡으로 로그인 성공, jwt = ${response.result[0].jwt}")

        // SharedPreferences 의 데이터를 저장/편집을 위해 Editor 변수를 선언
        val editor = sSharedPreferences.edit()

        // key값에 value값을 저장
        editor.putString(X_ACCESS_TOKEN, response.result[0].jwt)
//        editor.putString(X_ACCESS_TOKEN, "0")

        // 메모리에 있는 데이터를 저장장치에 저장함. commit
        editor.commit()

//        X_ACCESS_TOKEN = response.result[0].jwt

        if (response.code == 1000) {
            Log.e(ApplicationClass.TAG, "login activity: X_ACCESS_TOKEN? " +
                    "${sSharedPreferences.getString(X_ACCESS_TOKEN, "")}")
            Log.e(TAG, "onPostLoginSuccess: 로그인 성공")
            response.message?.let { showCustomToast(it) }

            //userIdx값 sharedpreference에 저장
            Log.e(TAG, "일반 로그인 성공, userIdx = ${response.result[0].userIdx}")

            // SharedPreferences 의 데이터를 저장/편집을 위해 Editor 변수를 선언
            val editor = ApplicationClass.sSharedPreferences.edit()

            // key값에 value값을 저장
            editor.putInt("userIdx", response.result[0].userIdx)

            // 메모리에 있는 데이터를 저장장치에 저장함. commit
            editor.commit()

            Log.e(TAG, "userIdx 저장됐는지 확인: ${sSharedPreferences.getInt("userIdx", 0)}")
            Log.e(TAG, "X_ACCESS_TOKEN 저장됐는지 확인: ${sSharedPreferences.getString(X_ACCESS_TOKEN, "")}")

            finish()
//            val intent = Intent(this, MyPageFragment::class.java)
//            startActivity(intent)
        }
    }

    override fun onPostLoginFailure(message: String, response: LoginResponse) {
        dismissLoadingDialog()
        Log.e(TAG, "onPostLoginFailure: 로그인 실패")
        when(response.code) {

            //토큰 존재X
            2000 -> {
                showCustomToast("$message")
            }

            //유효하지 않은 토큰
            3001 -> {
                showCustomToast("$message")
            }

        }
    }
}