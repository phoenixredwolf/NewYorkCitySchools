package com.phoenixredwolf.newyorkcityschools.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.phoenixredwolf.newyorkcityschools.component.DetailComponent
import com.phoenixredwolf.newyorkcityschools.component.ErrorUI
import com.phoenixredwolf.newyorkcityschools.component.LoadingUI
import com.phoenixredwolf.newyorkcityschools.component.TopBarComponent
import com.phoenixredwolf.newyorkcityschools.data.model.School
import com.phoenixredwolf.newyorkcityschools.ui.viewmodel.MainViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    navController: NavController,
    scrollState: ScrollState,
    school: School,
    viewModel: MainViewModel,
    isLoading: MutableState<Boolean>,
    isError: MutableState<Boolean>
) {

    when {
        isLoading.value -> {
            LoadingUI()
        }
        isError.value -> {
            ErrorUI()
        }
        else -> {
            val sat = if (viewModel.satResponse.collectAsState().value.isNotEmpty()) {
                viewModel.satResponse.collectAsState().value[0]!!
            } else {
                null
            }
            Scaffold(
                topBar = {
                    TopBarComponent(school, onBackPressed = {
                        navController.popBackStack()
                    })
                }
            ) {
                DetailComponent(scrollState = scrollState, school = school, sat = sat)
            }

        }
    }
}