package com.phoenixredwolf.newyorkcityschools.component

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.phoenixredwolf.newyorkcityschools.data.model.BottomMenu


@Composable
fun BottomBarComponent(navController: NavController) {

    val menuItems = listOf(
        BottomMenu.Home,
        BottomMenu.Search,
        BottomMenu.Favorites
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        menuItems.forEach {
            NavigationBarItem(
                label = { Text( text = it.title ) },
                alwaysShowLabel = true,
                selected = currentRoute == it.route,
                onClick = {
                    navController.navigate(it.route) {
                        navController.graph.startDestinationRoute?.let {
                                route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon ( imageVector = it.icon, contentDescription = it.title )
                }
            )
        }
    }
}