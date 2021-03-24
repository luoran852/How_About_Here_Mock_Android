package com.softsquared.template.kotlin.src.main.hotelSeoulDetail

import android.os.Bundle
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityHotelSeoulDetailBinding
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.model.HotelDetailResponse

class HotelSeoulDetailActivity : BaseActivity<ActivityHotelSeoulDetailBinding>
    (ActivityHotelSeoulDetailBinding::inflate), HotelSeoulDetailActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//    override fun onGetUserSuccess(response: UserResponse) {
//        dismissLoadingDialog()
//        for (User in response.result) {
//            Log.d("HomeFragment", User.toString())
//        }
//        binding.homeButtonTryGetJwt.text = response.message
//        showCustomToast("Get JWT 성공")
//        showCustomToast(response.message)
//    }



    }

    override fun onGetHotelDetailSuccess(response: HotelDetailResponse) {
        dismissLoadingDialog()
    }

    override fun onGetHotelDetailFailure(message: String, response: HotelDetailResponse) {
        dismissLoadingDialog()
    }

}