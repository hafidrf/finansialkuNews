package com.hafidrf.finansialku.data.state

import com.hafidrf.finansialku.data.model.news.ResponseNews

/**
 * Created by : com.hafidrf.finansialku
 */

sealed class NewsState {
    object Loading : NewsState()
    data class Result(val data : ResponseNews) : NewsState()
    data class Error(val error : Throwable) : NewsState()
}
