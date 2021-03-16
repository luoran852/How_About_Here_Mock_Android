package com.softsquared.template.kotlin.src.main.myPage

import android.content.Intent
import android.os.Bundle
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityPhoneCertificationBinding

class PhoneCertificationActivity : BaseActivity<ActivityPhoneCertificationBinding>
    (ActivityPhoneCertificationBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.sendAuthNum.setOnClickListener {
            val intent = Intent(this, RequiredInfoActivity::class.java)
            startActivity(intent)
        }
    }
}