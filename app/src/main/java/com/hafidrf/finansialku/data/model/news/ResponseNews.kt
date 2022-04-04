package com.hafidrf.finansialku.data.model.news

import com.google.gson.annotations.SerializedName

/**
 * Created by : com.hafidrf.finansialku
 */

data class ResponseNews(
        @SerializedName("status")
        val status: String = "",

        @SerializedName("totalResults")
        val totalResults: Int = 0,

        @SerializedName("articles")
        val data: List<DataNews> = emptyList()
)
