package com.softsquared.template.kotlin.src.main.hotelSeoulAll

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHotelSeoulAllBinding
import com.softsquared.template.kotlin.src.main.hotelSeoulAll.recyclerview.SeoulAllRecyclerViewAdapter
import com.softsquared.template.kotlin.src.main.hotelSeoulDetail.HotelSeoulDetailActivity

class HotelSeoulAllFragment : BaseFragment<FragmentHotelSeoulAllBinding>(
    FragmentHotelSeoulAllBinding::bind, R.layout.fragment_hotel_seoul_all) {

    // adapter
    private lateinit var seoulAllRecyclerViewAdapter: SeoulAllRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // back 버튼
        binding.hotelSeoulAllBackBtn.setOnClickListener {
            fragmentManager?.beginTransaction()?.remove(this)?.commit()
        }

        this.seoulAllRecyclerViewAdapter = SeoulAllRecyclerViewAdapter()

        binding.hotelSeoulAllRecyclerViewItems.layoutManager = GridLayoutManager(context,
        1, GridLayoutManager.VERTICAL, false)

        binding.hotelSeoulAllRecyclerViewItems.adapter = this.seoulAllRecyclerViewAdapter

        //호텔 detail 액티비티 부르기
        binding.hotelSeoulMdPickLayout.setOnClickListener {
            val intent = Intent(getActivity(), HotelSeoulDetailActivity::class.java)
            startActivity(intent)
        }



    }

}