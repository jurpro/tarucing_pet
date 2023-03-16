package com.ujanglukmanbdg.tarucingpet.ui.screen.favorite

import com.ujanglukmanbdg.tarucingpet.data.OrderAdopted

data class FavoriteState(
    val orderAdopted: List<OrderAdopted>,
    val totalRequiredPrice: Int
)
