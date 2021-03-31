package com.softsquared.template.kotlin.src.main.myPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.TAG
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.sSharedPreferences
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMyPageBinding
import com.softsquared.template.kotlin.src.main.hotelReservCheck.ReservCheckActivity
import com.softsquared.template.kotlin.src.main.login.LoginActivity
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageResponse
import com.softsquared.template.kotlin.src.main.myPage.model.PostMyPageRequest
import com.softsquared.template.kotlin.src.main.myPage.model.UserResponse
import com.softsquared.template.kotlin.src.main.search.SearchService

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind,
        R.layout.fragment_my_page), MyPageFragmentView {

    //login activity에 저장한 X_ACCESS_TOKEN
    val XACCESSTOKEN = sSharedPreferences.getString(X_ACCESS_TOKEN, "")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e(TAG, "XACCESSTOKEN = $XACCESSTOKEN")

        if (!(XACCESSTOKEN.equals(""))) {
            val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx", 0) //sf에 저장된 userIdx 가져오기

            showLoadingDialog(context!!)
            MyPageService(this).tryGetMyPage(userIdx)
        }


//        Log.e(TAG, "mypage : X_ACCESS_TOKEN? $XACCESSTOKEN")

//        val postRequest = PostMyPageRequest(XACCESSTOKEN = XACCESSTOKEN)
//        showLoadingDialog(context!!)
//        MyPageService(this).tryPostMyPage(postRequest)

        binding.myPageLoginLinearLayout.setOnClickListener {
            val intent = Intent(getActivity(), LoginActivity::class.java)
            startActivity(intent)
        }

        binding.myPageList1.setOnClickListener {
            val intent = Intent(getActivity(), ReservCheckActivity::class.java)
            startActivity(intent)
        }

    }

//    //POST 성공시
//    override fun onPostMyPageSuccess(response: UserResponse) {
//        dismissLoadingDialog()
//
//        //로그인 상태입니다.
//        if (response.code == 1000) {
//            Log.e(TAG, "onPostMyPageSuccess: 마이페이지 post 성공")
//
//            val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx", 0) //sf에 저장된 userIdx 가져오기
//
//            showLoadingDialog(context!!)
//            MyPageService(this).tryGetMyPage(userIdx)
//
//            binding.myPageLoginLinearLayout.visibility = View.INVISIBLE
//            binding.myPageUserInfoLayout.visibility = View.VISIBLE
//        }
//    }
//
//    override fun onPostMyPageFailure(message: String, response: UserResponse) {
//        dismissLoadingDialog()
//        Log.e(TAG, "onPostMyPageFailure: 마이페이지 post 실패")
//        when(response.code) {
//
//            //비로그인 상태입니다.
//            3000 -> {
//                showCustomToast("$message")
//            }
//
//        }
//    }

    override fun onGetMyPageSuccess(response: MyPageResponse) {
        dismissLoadingDialog()

        if(response.code == 1000) {

            Log.e(TAG, "onGetMyPageSuccess: ${response.message}")
            Log.e(TAG, "마이페이지 조회 결과 = ${response.result}")
            // 마이페이지 조회 성공
            response.message?.let { showCustomToast(it) }



            binding.myPageLoginLinearLayout.visibility = View.INVISIBLE
            binding.myPageUserInfoLayout.visibility = View.VISIBLE

            val result = response.result

            //사용자 프로필 사진
            Glide.with(this).load(result[0]?.profile).into(binding.mypageUserImg)

            binding.mypageUserName.text = result[0].nickname //닉네임
        }
    }

    override fun onGetMyPageFailure(message: String, response: MyPageResponse) {
        dismissLoadingDialog()
        Log.e(TAG, "onGetMyPageFailure: ${response.message}")
        when(response.code) {

            //jwt토큰 존재 x
            2000 -> {
                showCustomToast("$message")
            }

            //jwt토큰 유효하지 않음
            3000 -> {
                showCustomToast("$message")
            }

            //권한이 없는 유저(userIdx와 jwt의 userIdx불일치)
            3001 -> {
                showCustomToast("$message")
            }

        }
    }

}