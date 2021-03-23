package com.softsquared.template.kotlin.src.main.search

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind,
        R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction()
                .replace(R.id.search_frame, SearchRoomFragment())
                .commitAllowingStateLoss()

        binding.searchTabRoom.setOnClickListener(){
            childFragmentManager.beginTransaction()
                    .replace(R.id.search_frame, SearchRoomFragment())
                    .commitAllowingStateLoss()
        }

        binding.searchTabActivity.setOnClickListener(){
            childFragmentManager.beginTransaction()
                    .replace(R.id.search_frame, SearchActivityFragment())
                    .commitAllowingStateLoss()
        }

    }

}
