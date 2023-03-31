package com.phoenixredwolf.newyorkcityschools.ui.views

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.phoenixredwolf.newyorkcityschools.ui.screens.MainScreen
import com.phoenixredwolf.newyorkcityschools.ui.viewmodel.MainViewModel

@Composable
fun SchoolApp(mainViewModel: MainViewModel) {

    val navController = rememberNavController()

    MainScreen(navController,mainViewModel)
}