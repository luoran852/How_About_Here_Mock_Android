package com.softsquared.template.kotlin.src.main.search

import com.softsquared.template.kotlin.src.main.search.model.SearchResponse


interface SearchNewFragmentView {

    fun onGetSearchSuccess(response: SearchResponse)

    fun onGetSearchFailure(message: String, response: SearchResponse)

}