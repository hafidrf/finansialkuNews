package com.hafidrf.finansialku.data.state

import com.hafidrf.finansialku.data.model.source.ResponseSource

/**
 * Created by : com.hafidrf.finansialku
 */

sealed class SourceState {
    object Loading : SourceState()
    data class Result(val data : ResponseSource) : SourceState()
    data class Error(val error : Throwable) : SourceState()
}
