package com.softsquared.template.kotlin.src.main.hotelReservCheck

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.softsquared.template.kotlin.src.main.hotelReservCheckAfter.ReservCheckBeforeFragment
import com.softsquared.template.kotlin.src.main.hotelReservCheckBefore.ReservCheckAfterFragment
import com.softsquared.template.kotlin.src.main.hotelReservCheckCanceled.ReservCheckCanceledFragment


class ReservPageAdapter(fm: FragmentManager, var mNumOfTabs: Int) :
        FragmentStatePagerAdapter(fm, mNumOfTabs) {

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> ReservCheckBeforeFragment()
            1 -> ReservCheckAfterFragment()
            else -> ReservCheckCanceledFragment()
        }
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }

    override fun getPageTitle(position: Int): CharSequence? {
//        return super.getPageTitle(position) 이거 넣으면 글씨 안보임

        if (position == 0)
            return "이용전"
        else if (position == 1)
            return "이용후"
        else
            return "취소됨"

    }
}