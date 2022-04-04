package com.hafidrf.finansialku.data.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.hafidrf.finansialku.data.model.news.DataNews
import com.hafidrf.finansialku.data.source.SearchSource
import com.hafidrf.finansialku.data.state.NewsState
import javax.inject.Inject

/**
 * Created by : com.hafidrf.finansialku
 */

class SearchFactory @Inject constructor(
    private val source: SearchSource
) : DataSource.Factory<Int, DataNews>() {

    lateinit var liveData : MutableLiveData<NewsState>
    var query : String = ""

    override fun create(): DataSource<Int, DataNews> {
        return source.also {
            it.query = query
            it.liveData = liveData
        }
    }
}