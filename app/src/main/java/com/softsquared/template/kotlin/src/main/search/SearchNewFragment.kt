package com.softsquared.template.kotlin.src.main.search

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentSearchSeoulBinding
import com.softsquared.template.kotlin.src.main.search.recyclerview.SearchRecyclerViewAdapter

class SearchNewFragment : BaseFragment<FragmentSearchSeoulBinding>(FragmentSearchSeoulBinding::bind,
    R.layout.fragment_search_seoul) {

    private lateinit var searchRecyclerViewAdapter: SearchRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.searchRecyclerViewAdapter = SearchRecyclerViewAdapter()

        binding.hotelSeoulAllRecyclerViewItems.layoutManager = GridLayoutManager(context,
            1, GridLayoutManager.VERTICAL, false)

        binding.hotelSeoulAllRecyclerViewItems.adapter = this.searchRecyclerViewAdapter
    }

}