package com.ujanglukmanbdg.tarucingpet.navigation

sealed class ScreenMenu(val route: String) {
    object Home: ScreenMenu("Home")
    object Favorite: ScreenMenu("Favorite")
    object Chat: ScreenMenu("Chat")
    object Profile: ScreenMenu("Profile")
    object About: ScreenMenu("About")
    object DetailAnimal: ScreenMenu("detail/{id}") { fun createRoute(id: Int) = "detail/$id" }
}
