package com.softsquared.template.kotlin.src.main.search

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentSearchActivityBinding

class SearchActivityFragment : BaseFragment<FragmentSearchActivityBinding>(FragmentSearchActivityBinding::bind,
        R.layout.fragment_search_activity) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}