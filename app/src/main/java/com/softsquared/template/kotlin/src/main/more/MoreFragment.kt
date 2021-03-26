package com.softsquared.template.kotlin.src.main.more

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMoreBinding

class MoreFragment : BaseFragment<FragmentMoreBinding>(FragmentMoreBinding::bind,
        R.layout.fragment_more) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}