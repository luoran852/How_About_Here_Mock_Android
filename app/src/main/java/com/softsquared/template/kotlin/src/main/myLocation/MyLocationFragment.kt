package com.softsquared.template.kotlin.src.main.myLocation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMyLocationBinding
import com.softsquared.template.kotlin.src.main.myLocation.recyclerview.MyLocationRecyclerViewAdpater

class MyLocationFragment : BaseFragment<FragmentMyLocationBinding>(FragmentMyLocationBinding::bind,
        R.layout.fragment_my_location) {

    private lateinit var myLocationRecyclerViewAdpater: MyLocationRecyclerViewAdpater

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.myLocationRecyclerViewAdpater = MyLocationRecyclerViewAdpater()

        binding.myLocationRecyclerView.layoutManager = GridLayoutManager(context,
            1, GridLayoutManager.VERTICAL, false)

        binding.myLocationRecyclerView.adapter = this.myLocationRecyclerViewAdpater
    }

}