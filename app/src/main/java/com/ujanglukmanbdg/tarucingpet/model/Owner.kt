package com.ujanglukmanbdg.tarucingpet.model

data class Owner(
    val id: Int,
    val name: String,
    val bio: String,
    val address: String,
    val image: Int,
)

/* val dummyOwner = listOf(
    Owner(R.drawable.menu1, "Tiramisu Coffee Milk", "Rp 28.000"),
    Menu(R.drawable.menu2,"Pumpkin Spice Latte", "Rp 18.000"),
    Menu(R.drawable.menu3, "Light Cappuccino", "Rp 20.000"),
    Menu(R.drawable.menu4, "Choco Creamy Latte", "Rp 16.000")
)

val dummyBestSellerMenu = dummyMenu.shuffled() */