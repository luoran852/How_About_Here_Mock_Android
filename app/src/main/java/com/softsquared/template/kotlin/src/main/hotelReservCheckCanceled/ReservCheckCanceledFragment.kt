package com.softsquared.template.kotlin.src.main.hotelReservCheckCanceled

import android.os.Bundle
import android.util.Log
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentReservationCheckCanceledBinding

class ReservCheckCanceledFragment : BaseFragment<FragmentReservationCheckCanceledBinding>
        (FragmentReservationCheckCanceledBinding::bind, R.layout.fragment_reservation_check_canceled) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(ApplicationClass.TAG, "onViewCreated: fragment_reservation_check_canceled")
    }

}