package com.softsquared.template.kotlin.src.main.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHomeBinding
import com.softsquared.template.kotlin.src.main.hotelArea.HotelAreaFragment
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.HotelSeoulDetailActivity
import com.softsquared.template.kotlin.src.main.login.LoginActivity

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind,
        R.layout.fragment_home), HomeFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 호텔 아이콘 클릭
        binding.homeHotel.setOnClickListener {
            fragmentManager?.beginTransaction()?.add(R.id.main_frm, HotelAreaFragment())
                    ?.addToBackStack(null)?.commit()
        }

        //호텔 detail 액티비티 부르기(모텔 아이콘으로 test)
        binding.icHomeMotel2.setOnClickListener {
            val intent = Intent(getActivity(), HotelSeoulDetailActivity::class.java)
            startActivity(intent)
        }

//        binding.homeBtnTryPostHttpMethod.setOnClickListener {
//            val email = binding.homeEtId.text.toString()
//            val password = binding.homeEtPw.text.toString()
//            val postRequest = PostSignUpRequest(id = email, pwd = password,
//                nickname = "test", phone = "010-0000-0000")
//            showLoadingDialog(context!!)
//            HomeService(this).tryPostSignUp(postRequest)
//        }
    }

//    override fun onGetUserSuccess(response: UserResponse) {
//        dismissLoadingDialog()
//        for (User in response.result) {
//            Log.d("HomeFragment", User.toString())
//        }
//        binding.homeButtonTryGetJwt.text = response.message
////        showCustomToast("Get JWT 성공")
//        showCustomToast(response.message)
//    }
//
//    override fun onGetUserFailure(message: String) {
//        dismissLoadingDialog()
//        showCustomToast("오류 : $message")
//    }

//    override fun onPostSignUpSuccess(response: SignUpResponse) {
//        dismissLoadingDialog()
//        binding.homeBtnTryPostHttpMethod.text = response.message
//        response.message?.let { showCustomToast(it) }
//    }
//
//    override fun onPostSignUpFailure(message: String) {
//        dismissLoadingDialog()
//        showCustomToast("오류 : $message")
//    }
}