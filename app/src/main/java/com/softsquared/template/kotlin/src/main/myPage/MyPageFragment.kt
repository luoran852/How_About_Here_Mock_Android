package com.softsquared.template.kotlin.src.main.myPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.TAG
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.sSharedPreferences
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMyPageBinding
import com.softsquared.template.kotlin.src.main.hotelReservCheck.ReservCheckActivity
import com.softsquared.template.kotlin.src.main.login.LoginActivity
import com.softsquared.template.kotlin.src.main.myPage.model.PostMyPageRequest
import com.softsquared.template.kotlin.src.main.myPage.model.UserResponse

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind,
        R.layout.fragment_my_page), MyPageFragmentView {

    //login activity에 저장한 X_ACCESS_TOKEN
    val XACCESSTOKEN = sSharedPreferences.getString(X_ACCESS_TOKEN, "")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e(TAG, "mypage : X_ACCESS_TOKEN? $XACCESSTOKEN")

        val postRequest = PostMyPageRequest(XACCESSTOKEN = XACCESSTOKEN)
        showLoadingDialog(context!!)
        MyPageService(this).tryPostMyPage(postRequest)

        binding.myPageLoginLinearLayout.setOnClickListener {
            val intent = Intent(getActivity(), LoginActivity::class.java)
            startActivity(intent)
        }

        binding.myPageList1.setOnClickListener {
            val intent = Intent(getActivity(), ReservCheckActivity::class.java)
            startActivity(intent)
        }

    }

    //POST 성공시
    override fun onPostMyPageSuccess(response: UserResponse) {
        dismissLoadingDialog()

        //로그인 상태입니다.
        if (response.code == 1000) {
            Log.e(TAG, "onPostMyPageSuccess: 마이페이지 post 성공")
            Log.e(TAG, "mypage : X_ACCESS_TOKEN? $XACCESSTOKEN")
//            response.message?.let { showCustomToast(it) }
//            finish()
        }
    }

    override fun onPostMyPageFailure(message: String, response: UserResponse) {
        dismissLoadingDialog()
        Log.e(TAG, "onPostMyPageFailure: 마이페이지 post 실패")
        when(response.code) {

            //비로그인 상태입니다.
            3000 -> {
                showCustomToast("$message")
            }

        }
    }

}