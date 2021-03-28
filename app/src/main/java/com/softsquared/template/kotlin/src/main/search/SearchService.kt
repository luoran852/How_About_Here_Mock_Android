package com.softsquared.template.kotlin.src.main.search

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.search.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchService(val view: SearchNewFragmentView) {

    fun tryGetSearch(keyword: String?, checkIn: Int, checkOut: Int, alignIdx: Int) {
        val getSearchRetrofitInterface = ApplicationClass.sRetrofit.create(GetSearchRetrofitInterface::class.java)
        getSearchRetrofitInterface.getSearch(keyword, checkIn, checkOut, alignIdx).enqueue(object :
                Callback<SearchResponse> {
            override fun onResponse(
                    call: Call<SearchResponse>,
                    response: Response<SearchResponse>
            ) {
                Log.e(ApplicationClass.TAG, "onResponse: tryGetSearch 성공, ${response.message()}")
                view.onGetSearchSuccess(response.body() as SearchResponse)
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Log.e(ApplicationClass.TAG, "onFailure: tryGetSearch 실패, ${t.message}")
                view.onGetSearchFailure(t.message ?: "통신 오류", this as SearchResponse)
            }

        })

    }

}