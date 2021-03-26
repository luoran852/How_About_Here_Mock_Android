package com.softsquared.template.kotlin.src.main.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentSearchRoomBinding

class SearchRoomFragment : BaseFragment<FragmentSearchRoomBinding>(
    FragmentSearchRoomBinding::bind,
    R.layout.fragment_search_room
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchTermEditText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            //Enter key Action
            if (event.action === KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                //Enter키눌렀을떄 처리
                fragmentManager?.beginTransaction()?.add(R.id.search_frame_all, SearchNewFragment())
                    ?.addToBackStack(null)?.commit()
                true
            } else false
        })

    }
}