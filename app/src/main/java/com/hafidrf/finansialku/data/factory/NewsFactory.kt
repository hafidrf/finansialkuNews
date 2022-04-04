package com.hafidrf.finansialku.data.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.hafidrf.finansialku.data.model.news.DataNews
import com.hafidrf.finansialku.data.source.NewsSource
import com.hafidrf.finansialku.data.state.NewsState
import javax.inject.Inject

/**
 * Created by : com.hafidrf.finansialku
 */

class NewsFactory @Inject constructor(
    private val source: NewsSource
) : DataSource.Factory<Int, DataNews>() {

    lateinit var liveData : MutableLiveData<NewsState>
    var sources : String = ""

    override fun create(): DataSource<Int, DataNews> {
        return source.also {
            it.sources = sources
            it.liveData = liveData
        }
    }
}