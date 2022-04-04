package com.hafidrf.finansialku.data.model.categories

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by : com.hafidrf.finansialku
 */

@Parcelize
data class Categories(
        var id: String?,
        var title: String?,
        var icon: String?,
        var color: String?
) : Parcelable
