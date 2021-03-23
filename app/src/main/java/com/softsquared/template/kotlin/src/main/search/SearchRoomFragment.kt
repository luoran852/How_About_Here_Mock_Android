package com.softsquared.template.kotlin.src.main.search

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentSearchRoomBinding

class SearchRoomFragment : BaseFragment<FragmentSearchRoomBinding>(FragmentSearchRoomBinding::bind,
        R.layout.fragment_search_room) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}