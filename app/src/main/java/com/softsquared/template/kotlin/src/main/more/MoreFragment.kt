package com.softsquared.template.kotlin.src.main.more

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMoreBinding
import com.softsquared.template.kotlin.databinding.FragmentMyPageBinding

class MoreFragment : BaseFragment<FragmentMoreBinding>(FragmentMoreBinding::bind,
        R.layout.fragment_more) {

    private var mCount = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonChangeCounterText.setOnClickListener {
            binding.textViewCounter.text =
                    resources.getString(R.string.my_page_tv_counter, ++mCount)
        }
    }

}