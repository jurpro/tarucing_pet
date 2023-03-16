package com.ujanglukmanbdg.tarucingpet.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ujanglukmanbdg.tarucingpet.R

data class Category(
    @DrawableRes val imageCategory: Int,
    @StringRes val textCategory: Int
)

val dummyCategory = listOf(
    R.drawable.icon_kucing_1 to R.string.animal_type_1,
    R.drawable.icon_kucing_2 to R.string.animal_type_2,
    R.drawable.icon_kucing_3 to R.string.animal_type_3,
    R.drawable.icon_kucing_2 to R.string.animal_type_4,
    R.drawable.icon_kucing_2 to R.string.animal_type_5,
).map { Category(it.first, it.second) }
