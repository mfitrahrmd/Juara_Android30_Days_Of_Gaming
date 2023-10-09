package com.mfitrahrmd.juara_android_30_days_of_gaming.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class GamingTodo(
    val day: Int,
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)
