package com.phoenixredwolf.newyorkcityschools.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.phoenixredwolf.newyorkcityschools.component.ErrorUI
import com.phoenixredwolf.newyorkcityschools.component.LoadingUI
import com.phoenixredwolf.newyorkcityschools.component.SchoolComponent
import com.phoenixredwolf.newyorkcityschools.data.model.School

@Composable
fun HomeScreen(
    navController: NavController,
    schools: List<School>,
    isLoading: MutableState<Boolean>,
    isError: MutableState<Boolean>
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val resultList = mutableListOf<School>()
        resultList.addAll(schools)

        when {
            isLoading.value -> {
                LoadingUI()
            }
            isError.value -> {
                ErrorUI()
            } else -> {
            LazyColumn {
                items(resultList.size) {
                        index ->
                    SchoolComponent(
                        school = resultList[index],
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