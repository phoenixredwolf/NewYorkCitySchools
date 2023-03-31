package com.phoenixredwolf.newyorkcityschools.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.phoenixredwolf.newyorkcityschools.component.ErrorUI
import com.phoenixredwolf.newyorkcityschools.component.LoadingUI
import com.phoenixredwolf.newyorkcityschools.component.TopBarComponent
import com.phoenixredwolf.newyorkcityschools.component.WebViewComponent


@Composable
fun WebviewScreen(
    url: String,
    isLoading: MutableState<Boolean>,
    isError: MutableState<Boolean>,
    navController: NavController,
    bottomBarState: MutableState<Boolean>
){

    when {
        isLoading.value -> {
            LoadingUI()
        }
        isError.value -> {
            ErrorUI()
        }
        else -> {
            Scaffold(
                topBar = {
                    TopBarComponent(school = null, onBackPressed = {
                        navController.popBackStack()
                        bottomBarState.value = true
                    })
                }
            ) {
                Column(modifier = Modifier.padding(it)) {
                    WebViewComponent(url = url, Modifier.fillMaxSize())
                }
            }
        }
    }
}