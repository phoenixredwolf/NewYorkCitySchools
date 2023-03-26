package com.phoenixredwolf.newyorkcityschools.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.phoenixredwolf.newyorkcityschools.component.BottomBarComponent
import com.phoenixredwolf.newyorkcityschools.component.Navigation
import com.phoenixredwolf.newyorkcityschools.ui.viewmodel.MainViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    scrollState: ScrollState,
    mainViewModel: MainViewModel
) {
    Scaffold(
        bottomBar = {
            BottomBarComponent(navController = navController)
        }
    ) {
        Navigation(
            navController = navController,
            scrollState = scrollState,
            paddingValues = it,
            viewModel = mainViewModel
        )
    }
}