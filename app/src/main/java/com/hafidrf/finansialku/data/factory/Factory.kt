package com.hafidrf.finansialku.data.factory

import javax.inject.Inject

/**
 * Created by : com.hafidrf.finansialku
 */

data class Factory @Inject constructor(
    val newsFactory : NewsFactory,
    val searchFactory : SearchFactory
)
