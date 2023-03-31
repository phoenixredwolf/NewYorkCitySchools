package com.phoenixredwolf.newyorkcityschools.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import com.phoenixredwolf.newyorkcityschools.component.BottomBarComponent
import com.phoenixredwolf.newyorkcityschools.component.Navigation
import com.phoenixredwolf.newyorkcityschools.ui.viewmodel.MainViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel
) {
    val bottomBarState = rememberSaveable { mutableStateOf(true) }

    Scaffold(
        bottomBar = {
            BottomBarComponent(navController = navController, bottomBarState)
        }
    ) {
        Navigation(
            navController = navController,
            paddingValues = it,
            viewModel = mainViewModel,
            bottomBarState = bottomBarState
        )
    }
}

