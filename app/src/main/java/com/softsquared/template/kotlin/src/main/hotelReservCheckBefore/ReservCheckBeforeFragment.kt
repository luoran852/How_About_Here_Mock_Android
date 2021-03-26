package com.softsquared.template.kotlin.src.main.hotelReservCheckBefore

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.TAG
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentReservationCheckBeforeBinding

import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.recyclerview.ReservCheckBefoRecycAdapter
import com.softsquared.template.kotlin.src.main.search.SearchNewFragment

class ReservCheckBeforeFragment : BaseFragment<FragmentReservationCheckBeforeBinding>
        (FragmentReservationCheckBeforeBinding::bind, R.layout.fragment_reservation_check_before) {

    // adapter
    private lateinit var reservCheckBefoRecycAdapter: ReservCheckBefoRecycAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "onViewCreated: fragment_reservation_check_before")

        fragmentManager?.beginTransaction()?.add(R.id.container, SearchNewFragment())
            ?.addToBackStack(null)?.commit()
//        this.reservCheckBefoRecycAdapter = ReservCheckBefoRecycAdapter()
//
//        binding.reservationCheckBeforeRecyclerview.layoutManager = GridLayoutManager(context,
//            1, GridLayoutManager.VERTICAL, false)
//
//        binding.reservationCheckBeforeRecyclerview.adapter = this.reservCheckBefoRecycAdapter

    }
}