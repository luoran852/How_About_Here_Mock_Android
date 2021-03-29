package com.softsquared.template.kotlin.src.main.search

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.TAG
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentSearchDetailBinding
import com.softsquared.template.kotlin.src.main.search.model.Result
import com.softsquared.template.kotlin.src.main.search.model.SearchResponse
import com.softsquared.template.kotlin.src.main.search.recyclerview.SearchRecyclerViewAdapter

class SearchNewFragment : BaseFragment<FragmentSearchDetailBinding>(FragmentSearchDetailBinding::bind,
    R.layout.fragment_search_detail), SearchNewFragmentView {

    lateinit var keyword: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        keyword = arguments?.getString("keyword").toString()
        Log.e(TAG, "onViewCreated: keyword = $keyword") //값 잘 받아오는지 확인
        val checkIn = 20210401
        val checkOut = 20210402
        val alignIdx = 1

        showLoadingDialog(context!!)
        SearchService(this).tryGetSearch(keyword, checkIn, checkOut, alignIdx)

    }

    override fun onGetSearchSuccess(response: SearchResponse) {
        dismissLoadingDialog()

        if(response.code == 1000) {

            Log.e(TAG, "onGetSearchSuccess: ${response.message}")
            Log.e(TAG, "${response.result}")
            // 숙소 검색 조회 성공
            response.message?.let { showCustomToast(it) }

            binding.searchKeywordTxt.text = keyword
            val result = response.result

            result[0].acmIdx

            var searchList: List<Result> = result
            binding.searchDetailRecyclerViewItems.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.searchDetailRecyclerViewItems.setHasFixedSize(true)
            binding.searchDetailRecyclerViewItems.adapter = searchList?.let { SearchRecyclerViewAdapter(it) }

        }
    }

    override fun onGetSearchFailure(message: String, response: SearchResponse) {
        dismissLoadingDialog()

        Log.e(TAG, "onGetSearchFailure: ${response.message}")
        when(response.code) {

            //올바르지 않은 categoryIdx
            2001 -> {
                showCustomToast("$message")
            }

            //정렬값 입력해주세요
            2002 -> {
                showCustomToast("$message")
            }

            //올바르지 않은 정렬값
            2003 -> {
                showCustomToast("$message")
            }

            //지역을 입력해주세요 / 검색어를 입력해주세요
            2004 -> {
                showCustomToast("$message")
            }

            //체크인 체크아웃 날짜를 입력해주세요
            2005 -> {
                showCustomToast("$message")
            }

            //날짜는 8자리를 입력해주세요
            2006 -> {
                showCustomToast("$message")
            }

            //존재하는 날짜가 아닙니다.
            2007 -> {
                showCustomToast("$message")
            }

            //사람수는 자연수를 입력해주세요
            2008 -> {
                showCustomToast("$message")
            }

            //올바르지 않은 type (1: 필터 조회/ 2: 검색조회)
            2010 -> {
                showCustomToast("$message")
            }

            //검색 결과가 없습니다.
            3001 -> {
                showCustomToast("$message")
            }

        }
    }

}