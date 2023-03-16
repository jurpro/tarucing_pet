package com.ujanglukmanbdg.tarucingpet

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults.containerColor
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ujanglukmanbdg.tarucingpet.data.SampleDataChat
import com.ujanglukmanbdg.tarucingpet.navigation.BottomBarItem
import com.ujanglukmanbdg.tarucingpet.navigation.ScreenMenu
import com.ujanglukmanbdg.tarucingpet.ui.screen.about.AboutScreen
import com.ujanglukmanbdg.tarucingpet.ui.screen.chat.CelebrityChatScreen
import com.ujanglukmanbdg.tarucingpet.ui.screen.detail.AnimalDetailScreen
import com.ujanglukmanbdg.tarucingpet.ui.screen.home.HomeScreen
import com.ujanglukmanbdg.tarucingpet.ui.screen.profile.ProfileScreen
import com.ujanglukmanbdg.tarucingpet.ui.theme.TarucingPetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TarucingApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != ScreenMenu.DetailAnimal.route) {
                NavigationBar(navController)
            }
        },
        modifier = modifier
    ) { paddingValues ->

        NavHost(navController = navController, startDestination = ScreenMenu.Home.route) {

            composable(ScreenMenu.Home.route) { HomeScreen(navController = navController, paddingValues = paddingValues) }

            composable(ScreenMenu.Chat.route) { CelebrityChatScreen( SampleDataChat.conversationSample ) }

            composable(ScreenMenu.Profile.route) { ProfileScreen() }

            composable(ScreenMenu.About.route) { AboutScreen() }

            composable(ScreenMenu.DetailAnimal.route, arguments = listOf(navArgument("id") { type = NavType.IntType })) {
                val id = it.arguments?.getInt("id") ?: 0
                AnimalDetailScreen(navController = navController, id = id)
            }
        }
    }
}

@Composable
private fun NavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colorScheme.contentColorFor(containerColor),
) {
    NavigationBar(modifier = modifier) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val items = listOf(
            BottomBarItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home,
                screen = ScreenMenu.Home,
            ),
            BottomBarItem(
                title = stringResource(R.string.menu_chat_celebrity),
                icon = Icons.Default.Create,
                screen = ScreenMenu.Chat
            ),
            BottomBarItem(
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountCircle,
                screen = ScreenMenu.Profile
            ),
            BottomBarItem(
                title = stringResource(R.string.menu_about),
                icon = Icons.Default.LocationOn,
                screen = ScreenMenu.About
            )
        )

        NavigationBar {
            items.map { item ->
                NavigationBarItem(
                    selected = currentRoute == item.screen.route,
                    label = { Text(item.title)},
                    icon = { Icon(imageVector = item.icon, contentDescription = item.title)},
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun TarucingAppPreview(){
    TarucingPetTheme{
        TarucingApp( )
    }
}
