package com.softsquared.template.kotlin.src.main.Agreement

import android.content.Intent
import android.os.Bundle
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityAgreementBinding
import com.softsquared.template.kotlin.src.main.phone.PhoneCertificationActivity

class AgreementActivity : BaseActivity<ActivityAgreementBinding>(ActivityAgreementBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding.agreementNextBtn.setOnClickListener {
            val intent = Intent(this, PhoneCertificationActivity::class.java)
            startActivity(intent)
        }
    }

}