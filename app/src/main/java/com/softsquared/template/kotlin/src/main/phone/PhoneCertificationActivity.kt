package com.softsquared.template.kotlin.src.main.phone

import android.content.Intent
import android.os.Bundle
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.sSharedPreferences
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityPhoneCertificationBinding
import com.softsquared.template.kotlin.src.main.required.RequiredInfoActivity

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