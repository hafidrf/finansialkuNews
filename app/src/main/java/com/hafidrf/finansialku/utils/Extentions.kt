package com.hafidrf.finansialku.utils

import android.content.Context

/**
 * Created by : com.hafidrf.finansialku
 */
object Extentions {

    fun Context.loadJSONFromAssets(fileName: String): String {
        return applicationContext.assets.open(fileName).bufferedReader().use { reader ->
            reader.readText()
        }
    }
}