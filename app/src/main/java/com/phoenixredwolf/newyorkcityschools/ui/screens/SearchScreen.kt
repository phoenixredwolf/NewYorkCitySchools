package com.phoenixredwolf.newyorkcityschools.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.phoenixredwolf.newyorkcityschools.component.*
import com.phoenixredwolf.newyorkcityschools.ui.viewmodel.MainViewModel

@Composable
fun SearchScreen(
    isLoading: MutableState<Boolean>,
    isError: MutableState<Boolean>,
    navController: NavController,
    viewModel: MainViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        BoroDropDownComponent(viewModel = viewModel)
        when {
            isLoading.value -> {
                LoadingUI()
            }
            isError.value -> {
                ErrorUI()
            }
            else -> {
                Column(
                    modifier = Modifier.fillMaxSize()
                ){

                    val schools = viewModel.schoolsResponse.collectAsState().value
                    LazyColumn {
                        items(schools.size) { index ->
                            SchoolComponent(
                                school = schools[index],
                                onSchoolClick = {
                                    navController.navigate("Detail/${index}")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}


