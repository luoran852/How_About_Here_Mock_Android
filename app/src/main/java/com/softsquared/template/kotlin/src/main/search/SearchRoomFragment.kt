package com.softsquared.template.kotlin.src.main.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.core.os.persistableBundleOf
import androidx.fragment.app.FragmentManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentSearchRoomBinding
import com.softsquared.template.kotlin.src.main.search.model.SearchResponse

class SearchRoomFragment : BaseFragment<FragmentSearchRoomBinding>(
    FragmentSearchRoomBinding::bind, R.layout.fragment_search_room) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchTermEditText.setOnKeyListener { v, keyCode, event ->
            //Enter key Action
            if (event.action === KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                //Enter키눌렀을떄 처리
                fragmentManager?.beginTransaction()?.add(R.id.search_frame_all, SearchNewFragment()
                        .apply {
                            arguments = Bundle().apply {
                                putString("keyword", binding.searchTermEditText.text.toString())
                            }
                        })
                        ?.addToBackStack(null)?.commit()
                true
            } else false
        }

    }
}