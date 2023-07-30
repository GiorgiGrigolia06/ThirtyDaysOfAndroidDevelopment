package com.example.thirtydaysofandroiddevelopment.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    @StringRes val dayOfTheMonth: Int,
    @StringRes val tipSummary: Int,
    @DrawableRes val tipImage: Int,
    @StringRes val tipDescription: Int
)